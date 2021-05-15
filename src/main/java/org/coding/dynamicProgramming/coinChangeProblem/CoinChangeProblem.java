package org.coding.dynamicProgramming.coinChangeProblem;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0)
    {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int Arr[] = new int[m];
      for(int i = 0;i<m;i++)
        Arr[i] = sc.nextInt();
      Solution ob = new Solution();
      System.out.println(ob.count(Arr,m,n));
    }
  }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
  private static long[][] dp;

  public long count(int S[], int m, int n)
  {
    dp = new long[m+1][n+1];

    for(long[] row: dp)
    {
      Arrays.fill(row,-1);
    }

    return getCount(S,m,n);
  }

  public long getCount(int S[], int m, int n)
  {
    if(n==0)
    {
      return 1;
    }

    if(m==0)
    {
      return 0;
    }

    if (dp[m][n] == -1) {

      if (S[m - 1] <= n) {
        dp[m][n] = getCount(S, m, n - S[m - 1]) + getCount(S, m - 1, n);
        return dp[m][n];
      } else {
        dp[m][n] =  getCount(S, m - 1, n);
        return dp[m][n];
      }
    }
    else
    {
      return dp[m][n];
    }

  }

}