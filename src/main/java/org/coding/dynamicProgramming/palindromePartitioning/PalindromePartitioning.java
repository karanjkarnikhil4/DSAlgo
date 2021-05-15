package org.coding.dynamicProgramming.palindromePartitioning;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
  public static void main(String args[])throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while(t-- > 0){
      String str = in.readLine();
      Solution ob = new Solution();
      System.out.println(ob.palindromicPartition(str));
    }
  }
}// } Driver Code Ends


//User function Template for Java

class Solution{

  private static int[][] dp;
  static int palindromicPartition(String str)
  {
    dp = new int[str.length()+1][str.length()+1];

    for(int[] row : dp)
    {
      Arrays.fill(row,-1);
    }
    // code here
    return  minimumPartitions(str,0,str.length()-1);
  }

  private static int minimumPartitions(String X, int i, int j)
  {

    if(j-i <=1)
    {
      return 0;
    }

    if(isPalindrome(X, i,j))
    {
       return 0;
    }

    if (dp[i][j] == -1) {

      int min = Integer.MAX_VALUE;

      for (int k = i; k <= j-1; k++) {
        int min1;
        int min2;

        min1 = minimumPartitions(X,i,k);
        min2 = minimumPartitions(X,k+1,j);

        min = Math.min(min, (min1 + min2 + 1));
      }

      dp[i][j] = min;
      return dp[i][j];
    }
    else
    {
      return dp[i][j];
    }

  }

  private static boolean isPalindrome(String str, int m ,int n)
  {
    boolean isPalindrome = true;
    for(int i=m,j=n; i<= n && j>=m && i<=j; i++, j--)
    {
      if(str.charAt(i) != str.charAt(j))
      {
        isPalindrome = false;
      }
    }
    return isPalindrome;
  }
}