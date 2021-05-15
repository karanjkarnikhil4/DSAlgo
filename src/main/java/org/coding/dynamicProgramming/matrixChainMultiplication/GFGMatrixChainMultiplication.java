package org.coding.dynamicProgramming.matrixChainMultiplication;


// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG1
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

      Solution1 ob = new Solution1();
      System.out.println(ob.matrixMultiplication(N, arr));
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution1{


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

    if (i == j)
      return 0;

    if (dp[i][j] == -1) {
      int min = Integer.MAX_VALUE;

      // place parenthesis at different places between first
      // and last matrix, recursively calculate count of
      // multiplications for each parenthesis placement and
      // return the minimum count
      for (int k = i; k < j; k++) {
        int count = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];

        if (count < min) min = count;
      }

      // Return minimum count
      dp[i][j] =  min;
      return dp[i][j];
    }

    else
    {
      return dp[i][j];
    }
  }
}