package org.coding.dynamicProgramming.coinChangeMinimumNumberOfWays;

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
      int v = sc.nextInt();
      int m = sc.nextInt();
      int coins[] = new int[m];
      for(int i = 0;i<m;i++)
        coins[i] = sc.nextInt();
      Solution ob = new Solution();
      System.out.println(ob.minCoins(coins, m, v));
    }
  }
}    // } Driver Code Ends


class Solution{

  private static int[][] dp ;

  public int minCoins(int coins[], int M, int V)
  {
    // Your code goes here
    dp= new int[M+1][V+1];
    for(int[] row: dp)
    {
      Arrays.fill(row,-1);
    }

    int min =getMinCoins(coins,M,V);
    if(min< Integer.MAX_VALUE-1)
    {
      return min;
    }
    else
    {
      return -1;
    }

  }

  public int getMinCoins(int coins[], int M, int V)
  {
    // Your code goes here
    if(V==0 && M==0)
    {
      return Integer.MAX_VALUE-1;
    }

    // Your code goes here
    if(V==0)
    {
      return 0;
    }

    if(M==0)
    {
      return Integer.MAX_VALUE-1;
    }

    if (dp[M][V] == -1) {

      if (coins[M - 1] <= V) {
        dp[M][V] =  Math.min(1+getMinCoins(coins, M, V - coins[M - 1]), getMinCoins(coins, M - 1, V));
        return dp[M][V];
      } else {
        dp[M][V]=  getMinCoins(coins, M - 1, V);
        return dp[M][V];
      }
    }
    else
    {
      return dp[M][V];
    }
  }
}