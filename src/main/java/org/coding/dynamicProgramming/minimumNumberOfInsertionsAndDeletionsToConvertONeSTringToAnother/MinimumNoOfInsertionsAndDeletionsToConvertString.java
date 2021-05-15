package org.coding.dynamicProgramming.minimumNumberOfInsertionsAndDeletionsToConvertONeSTringToAnother;

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
      String s1 = sc.next();
      String s2 = sc.next();
      Solution ob = new Solution();
      System.out.println(ob.minOperations(s1,s2));
    }
  }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
  private static int[][] dp ;
  public int minOperations(String str1, String str2)
  {
    int m = str1.length();
    int n = str2.length();
    dp = new int[m+1][n+1];
    for(int[] row: dp)
    {
      Arrays.fill(row,-1);
    }
    int lcs = lcs(str1,str2,m,n);

    return (m - lcs) + (n-lcs);
    // Your code goes here
  }

  private int lcs(String s1, String s2, int m, int n)
  {
    if(m==0 || n==0)
    {
      return 0;
    }

    if (dp[m][n] == -1) {
      if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
        dp[m][n] = 1 + lcs(s1, s2, m - 1, n - 1);
        return dp[m][n];
      } else {
        dp[m][n] = Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        return dp[m][n];
      }
    }
    else
    {
      return dp[m][n];
    }
  }
}