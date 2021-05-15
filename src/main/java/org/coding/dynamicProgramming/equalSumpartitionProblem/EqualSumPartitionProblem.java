package org.coding.dynamicProgramming.equalSumpartitionProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while (t-- > 0) {
      int N = Integer.parseInt(in.readLine());
      String input_line[] = in.readLine().trim().split("\\s+");
      int arr[] = new int[N];
      for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);

      Solution ob = new Solution();
      int x = ob.equalPartition(N, arr);
      if (x == 1) System.out.println("YES");
      else System.out.println("NO");
    }
  }
} // } Driver Code Ends

// User function Template for Java

class Solution {

  static int[][] dp;
  static int equalPartition(int N, int arr[]) {
    int sum =0;
    for(int i =0; i< N;i++)
    {
      sum+=arr[i];
    }

    if(sum %2 !=0)
    {
      return 0;
    }

    else
    {
      dp= new int[N+1][sum+1];
      for(int[] row: dp)
      {
        Arrays.fill(row,-1);
      }
       if(equalPartitionPossible(arr,N,sum/2))
       {
         return 1;
       }
       else
       {
         return 0;
       }
    }

  }

  private static boolean equalPartitionPossible(int[] arr, int n, int sum) {

    if(sum ==0)
    {
      return true;
    }
    if(n ==0)
    {
      return false;
    }

    if(dp[n][sum]==-1)
    {

      if(arr[n-1]<=sum)
      {
        boolean value = equalPartitionPossible(arr, n-1, sum-arr[n-1]) || equalPartitionPossible(arr, n-1, sum);
        dp[n][sum]=value?  1:0;
        return value;
      }

      else
      {
        boolean value= equalPartitionPossible(arr, n-1, sum);
        dp[n][sum]=value?  1:0;
        return value;
      }
    }

    else
    {
      return dp[n][sum]==1?true:false;
    }

  }

}
