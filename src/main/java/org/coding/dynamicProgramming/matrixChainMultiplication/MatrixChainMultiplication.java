package org.coding.dynamicProgramming.matrixChainMultiplication;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
  public static void main(String args[])throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while(t-- > 0){
      int N = Integer.parseInt(in.readLine());
      String input_line[] = in.readLine().trim().split("\\s+");
      int arr[]= new int[N];
      for(int i = 0; i < N; i++)
        arr[i] = Integer.parseInt(input_line[i]);

      Solution ob = new Solution();
      System.out.println(ob.matrixMultiplication(N, arr));
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

  private static int[][] dp ;

  static int matrixMultiplication(int N, int arr[])
  {
    dp = new int[N+1][N+1];
    for(int[] row: dp)
    {
      Arrays.fill(row,-1);
    }
    // code here
    if(arr.length <3)
    {
      return 0;
    }

    return solve(arr, 1,arr.length-1);

  }

  private static int solve (int[] arr, int i , int j)
  {
    if(j-i <1)
    {
      return 0;
    }

    if (dp[i][j] == -1) {

      int min = Integer.MAX_VALUE;

      for (int k = i; k <= j - 1; k++) {
        int cost = (solve(arr, i, k) + solve(arr, k + 1, j)) + (arr[i - 1] * arr[k] * arr[j]);
        min = Math.min(cost, min);
      }
      dp[i][j]= min;
      return dp[i][j];
    }
    else
    {
      return dp[i][j];
    }
  }
}