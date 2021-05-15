package org.coding.dynamicProgramming.longestpalindromicsubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindromicSubsequence {

  /*You are required to complete below method */
  static class GfG
  {
    private static int longesPalindromicSubSequence(int startIndex, int endIndex,char[] inputStringArray,int[][] cache)
    {
        if(startIndex == endIndex)
        {
          return 1;
        }

        if(startIndex>endIndex)
        {
          return 0;
        }

        if(cache[startIndex][endIndex]==-1)
        {

         if(inputStringArray[startIndex] == inputStringArray[endIndex])
        {
          cache[startIndex][endIndex]= 2+ longesPalindromicSubSequence(startIndex+1, endIndex-1,inputStringArray,cache);
          return cache[startIndex][endIndex];
        }
         else {
           cache[startIndex][endIndex] = Math.max(longesPalindromicSubSequence(startIndex+1,endIndex,inputStringArray,cache),longesPalindromicSubSequence(startIndex,endIndex-1,inputStringArray,cache));
           return cache[startIndex][endIndex];
         }
        }
        else
        {
          return cache[startIndex][endIndex];
        }

    }

    int countPS(String s)
    {
      // Your code here
      if(s!=null)
      {

      int[][] cache = new int[s.length()][s.length()];
      for(int[] cacheRow: cache)
      {
        Arrays.fill(cacheRow,-1);
      }
      return longesPalindromicSubSequence(0, s.length()-1,s.toCharArray(),cache);
      }
      else
      {
        return 0;
      }
    }
  }

  // { Driver Code Starts
  static class Palindromic_Strings
  {
    public  void main(String args[])
    {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      sc.nextLine();
      while(t>0)
      {
        String str = sc.nextLine();
        //System.out.println(str.length());
        GfG g  = new GfG();
        System.out.println(g.countPS(str));
        t--;
      }
    }
  }// } Driver Code Ends

}
