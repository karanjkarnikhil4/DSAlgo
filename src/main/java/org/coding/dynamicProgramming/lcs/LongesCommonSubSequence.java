package org.coding.dynamicProgramming.lcs;// { Driver Code Starts
import java.util.*;
import java.lang.*;

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
    // your code here
    return longestCommonSubSequence(p-1,q-1,s1.toCharArray(),s2.toCharArray());
  }

  public static int longestCommonSubSequence(int s1Length, int s2Length, char[] s1, char[] s2)
  {
      if(s1Length<0 || s2Length<0)
      {
        return 0;
      }
      if(s1[s1Length] != s2[s2Length])
      {
        return Math.max(longestCommonSubSequence(s1Length-1,s2Length,s1,s2),longestCommonSubSequence(s1Length,s2Length-1,s1,s2));
      }
      else
      {
        return 1+ longestCommonSubSequence(s1Length-1,s2Length-1,s1,s2);
      }
  }
}