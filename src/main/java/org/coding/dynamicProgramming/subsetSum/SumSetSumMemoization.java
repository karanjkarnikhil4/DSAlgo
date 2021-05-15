package org.coding.dynamicProgramming.subsetSum;

import java.util.Arrays;
import javax.swing.DefaultListSelectionModel;

public class SumSetSumMemoization {
  /* Driver code */

  static int[][] dp;

  public static void main(String args[])
  {
    int set[] = { 3, 34, 4, 12, 5, 2 };
    int sum = 30;
    int n = set.length;
    dp= new int[n+1][sum+1];
    for(int[] row: dp)
    {
      Arrays.fill(row,-1);
    }

    if (isSubsetSum(set, n, sum) == true)
      System.out.println("Found a subset"
          + " with given sum");
    else
      System.out.println("No subset with"
          + " given sum");
  }

  private static boolean isSubsetSum(int[] set, int n, int sum) {

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

    if(set[n-1]<=sum)
    {
      boolean value = isSubsetSum(set, n-1, sum-set[n-1]) || isSubsetSum(set, n-1, sum);
      dp[n][sum]=value?  1:0;
      return value;
    }

    else
    {
      boolean value= isSubsetSum(set, n-1, sum);
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
