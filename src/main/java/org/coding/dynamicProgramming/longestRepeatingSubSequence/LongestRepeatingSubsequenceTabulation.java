package org.coding.dynamicProgramming.longestRepeatingSubSequence;
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG1
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while(T-->0)
    {
      String str = br.readLine().trim();
      Solution1 ob = new Solution1();
      int ans = ob.LongestRepeatingSubsequence(str);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution1
{
  private static  int[][] t;

  public int LongestRepeatingSubsequence(String str)
  {
    int m = str.length();
    int n = m;
    t = new int[m+1][m+1];
//
    for(int i =0; i< m+1; i++)
    {
      for(int j=0; j< n+1; j++)
      {
         if(i==0 || j==0)
         {
           t[i][j] =0;
           continue;
         }

         if(str.charAt(i-1)==str.charAt(j-1))
         {
           if(i==j)
           {
            t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
            }
           else
           {
             t[i][j] = 1+t[i-1][j-1];
           }

         }
         else
         {
           t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
         }
      }
    }

    return t[m][n];



   // return longestRepeatingSubSequence(str,str,m, m);
    // code here
  }

  private int longestRepeatingSubSequence(String s1,String s2, int m, int n)
  {
    if(m==0 || n==0)
    {
      return 0;
    }

    if (t[m][n] == -1) {

      if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
        if (m != n) {
          t[m][n]= 1 + longestRepeatingSubSequence(s1, s2, m - 1, n - 1);
          return t[m][n];
        } else {
          t[m][n]= Math.max(
              longestRepeatingSubSequence(s1, s2, m - 1, n),
              longestRepeatingSubSequence(s1, s2, m, n - 1));
          return t[m][n];
        }
      } else {
        t[m][n]= Math.max(
            longestRepeatingSubSequence(s1, s2, m - 1, n),
            longestRepeatingSubSequence(s1, s2, m, n - 1));
        return t[m][n];
      }
    }
    else
    {
      return t[m][n];
    }
  }
}