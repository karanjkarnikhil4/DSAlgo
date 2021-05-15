package org.coding.dynamicProgramming.minimumOfInsertionsInStringToMakeItPalindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GFG {

  private static  int[][] dp ;

  public static void main (String[] args) throws IOException {
    //code
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while(T-->0)
    {
      String str = br.readLine().trim();
      GFG ob = new GFG();
      int ans = ob.insertionsToMakeItPalindrome(str);
      System.out.println(ans);
    }
  }

  public static int insertionsToMakeItPalindrome(String str)
  {
    int m = str.length();
    dp = new int[m+1][m+1];
    for(int[] row:dp)
    {
      Arrays.fill(row,-1);
    }

    StringBuilder stringBuilder = new StringBuilder(str);
    //stringBuilder.reverse();

    return m-getinsertionsToMakeItPalindrome(str,stringBuilder.reverse().toString(),m, m);
    // code here
  }

  private static int getinsertionsToMakeItPalindrome(String s1,String s2, int m, int n)
  {
    if(m==0 || n==0)
    {
      return 0;
    }

    if (dp[m][n] == -1) {

      if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
          dp[m][n]= 1 + getinsertionsToMakeItPalindrome(s1, s2, m - 1, n - 1);
          return dp[m][n];
        } else {
          dp[m][n]= Math.max(
              getinsertionsToMakeItPalindrome(s1, s2, m - 1, n),
              getinsertionsToMakeItPalindrome(s1, s2, m, n - 1));
          return dp[m][n];
        }
      }
    else
    {
      return dp[m][n];
    }
  }
}
