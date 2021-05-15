package org.coding.dynamicProgramming.longestCommonSubsequenceRefined;

// { Driver Code Starts
import java.util.*;
import java.lang.*;

class GFGLCSTabulation {
  public static void main (String[] args) {

    Scanner sc=new Scanner(System.in);
    int test=sc.nextInt();
    while(test-- > 0){
      int p=sc.nextInt();             // Take size of both the strings as input
      int q=sc.nextInt();

      String s1=sc.next();            // Take both the string as input
      String s2=sc.next();

      LCSTabulation obj = new LCSTabulation();

      System.out.println(obj.longestCommonSubSequence(s1, s2));
    }
  }
}// } Driver Code Ends


class LCSTabulation{

  // function to find LCS
  static int longestCommonSubSequence(String text1, String text2){
    int p = text1.length();
    int q = text2.length();
       int[][] t = new int[p+1][q+1];
       for(int[] row: t)
       {
         Arrays.fill(row,0);
       }


    //initialization code
    for(int i=0; i < p+1; i++)
    {
      for(int j=0; j< q+1; j++)
      {
        if(i==0 || j==0)
        {
          t[i][j] = 0;
        }
      }
    }

    for (int i =1; i< p+1; i++)
    {
      for(int j=1;j<q+1; j++)
      {
        if(text1.charAt(i-1)==text2.charAt(j-1))
        {
          t[i][j] = 1+ t[i-1][j-1];
        }

        else
        {
          t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
        }
      }
    }
    return t[p][q];
  }

}
