package org.coding.dynamicProgramming.shortestCommonSuperSequence;

// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
  public static void main (String[] args) {

    //taking input using Scanner class
    Scanner sc=new Scanner(System.in);

    //taking total testcases
    int t=sc.nextInt();

    sc.nextLine();
    while(t-->0)
    {
      //taking String X and Y
      String S[]=sc.nextLine().split(" ");
      String X=S[0];
      String Y=S[1];

      //calling function shortestCommonSupersequence()
      System.out.println(shortestCommonSupersequence(X, Y, X.length(), Y.length()));
    }
  }

  // } Driver Code Ends


//User function Template for Java

  public static int shortestCommonSupersequence(String X, String Y, int m, int n)
  {
    //Your code here
   int[][] dp = new int[m+1][n+1];
   for(int[] row: dp)
   {
     Arrays.fill(row,-1);
   }
   return getshortestCommonSupersequence(X,Y,m,n,dp);

  }

  private  static int getshortestCommonSupersequence(String X, String Y, int m, int n, int[][] dp)
  {
    if(m==0 && n==0)
    {
      return 0;
    }

    else if(m==0 && n!=0)
    {
      return n;
    }

    else if(n==0 & m!=0)
    {
      return m;
    }

    if (dp[m][n] == -1) {

      if (X.charAt(m - 1) == Y.charAt(n - 1)) {
        dp[m][n] = 1 + getshortestCommonSupersequence(X, Y, m - 1, n - 1,dp);
        return dp[m][n];
      } else {
        dp[m][n] = Math.min(
            1 + getshortestCommonSupersequence(X, Y, m - 1, n,dp),
            1 + getshortestCommonSupersequence(X, Y, m, n - 1,dp));
        return dp[m][n];
      }
    }

    else
    {
      return dp[m][n];
    }
  }

// { Driver Code Starts.




}  // }
