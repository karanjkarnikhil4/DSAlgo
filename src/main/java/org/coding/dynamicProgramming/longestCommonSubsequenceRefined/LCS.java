package org.coding.dynamicProgramming.longestCommonSubsequenceRefined;

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

  private static int[][] dp;
  // function to find LCS
  static int lcs(int p, int q, String s1, String s2){
   dp = new int[p+1][q+1];
   for(int[] row: dp)
   {
     Arrays.fill(row,-1);
   }
   return getLcs(p,q,s1,s2);

  }

  static int getLcs(int p, int q , String s1, String s2)
  {
    if(p==0 || q ==0)
    {
      return 0;
    }

    if(dp[p][q] ==-1)
    {
      if(s1.charAt(p-1)==s2.charAt(q-1))
      {
        dp[p][q] = 1+ getLcs(p-1,q-1,s1,s2);
        return dp[p][q];
      }

      else
      {
        dp[p][q] =Math.max(getLcs(p-1,q,s1,s2),getLcs(p,q-1,s1,s2));
        return dp[p][q];
      }
    }
    else
    {
       return dp[p][q];
    }
  }
}
