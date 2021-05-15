package org.coding.dynamicProgramming.longestcommonsubsequence;

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main (String[] args) {

    Scanner sc=new Scanner(System.in);
    int test=sc.nextInt();
    while(test-- > 0){
      int p=sc.nextInt();             // Take size of both the strings as input
      int q=sc.nextInt();

      String s1=sc.next();            // Take both the string as input
      String s2=sc.next();

      LCS obj = new LCS();

      System.out.println(obj.lcs(p, q, s1, s2));
    }
  }
}// } Driver Code Ends


class LCS{

  // function to find LCS
  static int lcs(int p, int q, String s1, String s2){

      int[][] dp = new int[p][q];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
      }

      return longesCommonSubsequence(p-1,q-1,s1.toCharArray(),s2.toCharArray(),dp);

  }

  private static int longesCommonSubsequence(int firstStringIndex, int secondStringIndex, char[] s1, char[] s2, int[][] dp)
  {

    if(firstStringIndex<0 || secondStringIndex<0)
    {
      return 0;
    }

    if(dp[firstStringIndex][secondStringIndex]==-1)
    {

     if(s1[firstStringIndex] == s2[secondStringIndex])
    {
        int lcs =longesCommonSubsequence(firstStringIndex-1,secondStringIndex-1,s1,s2,dp);
        dp[firstStringIndex][secondStringIndex]=lcs+1;
        return dp[firstStringIndex][secondStringIndex];
    }

    else
     {
       int firstLCS = longesCommonSubsequence(firstStringIndex-1,secondStringIndex,s1,s2,dp);
       int secondLCS = longesCommonSubsequence(firstStringIndex,secondStringIndex-1,s1,s2,dp);
       dp[firstStringIndex][secondStringIndex]= Math.max(firstLCS,secondLCS);
       return dp[firstStringIndex][secondStringIndex];
     }
  }

    else
    {
       return dp[firstStringIndex][secondStringIndex];
    }

}
}