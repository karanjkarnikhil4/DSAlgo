package org.coding.dynamicProgramming.longestRepeatingSubSequence;

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while(T-->0)
    {
      String str = br.readLine().trim();
      Solution ob = new Solution();
      int ans = ob.LongestRepeatingSubsequence(str);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
  private static  int[][] dp ;

  public int LongestRepeatingSubsequence(String str)
  {
    int m = str.length();

    dp = new int[m+1][m+1];
    for(int[] row:dp)
    {
      Arrays.fill(row,-1);
    }

    return longestRepeatingSubSequence(str,str,m, m);
    // code here
  }

  private int longestRepeatingSubSequence(String s1,String s2, int m, int n)
  {
      if(m==0 || n==0)
      {
        return 0;
      }

    if (dp[m][n] == -1) {

      if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
        if (m != n) {
          dp[m][n]= 1 + longestRepeatingSubSequence(s1, s2, m - 1, n - 1);
          return dp[m][n];
        } else {
          dp[m][n]= Math.max(
              longestRepeatingSubSequence(s1, s2, m - 1, n),
              longestRepeatingSubSequence(s1, s2, m, n - 1));
          return dp[m][n];
        }
      } else {
        dp[m][n]= Math.max(
            longestRepeatingSubSequence(s1, s2, m - 1, n),
            longestRepeatingSubSequence(s1, s2, m, n - 1));
        return dp[m][n];
      }
      }
    else
    {
      return dp[m][n];
    }
  }
}