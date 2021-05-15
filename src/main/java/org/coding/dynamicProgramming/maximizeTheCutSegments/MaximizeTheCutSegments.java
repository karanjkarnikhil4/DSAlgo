package org.coding.dynamicProgramming.maximizeTheCutSegments;
// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
  public static void main(String args[])throws IOException
  {
    //reading input using BufferedReader class
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    //reading total testcases
    int t = Integer.parseInt(read.readLine());

    while(t-- > 0)
    {
      //reading length of line segment
      int n = Integer.parseInt(read.readLine().trim());


      //reading 3 segment lengths
      String str[] = read.readLine().trim().split(" ");

      int x = Integer.parseInt(str[0]);
      int y = Integer.parseInt(str[1]);
      int z = Integer.parseInt(str[2]);


      //calling method maximizeCuts() of class Solution()
      //and printinting the result
      System.out.println(new Solution().maximizeCuts(n, x, y, z));
    }
  }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
  private int[][] dp;
  public int maximizeCuts(int n, int x, int y, int z)
  {
    int[] cuts = new int[3];
      cuts[0] =x;
      cuts[1] = y;
      cuts[2] = z;
      dp = new int[4][n+1];
      for(int[] row: dp)
      {
        Arrays.fill(row,-1);
      }

    int max =getMaximumCuts(cuts,3,n);
      if (max>0)
        return max;
      else
        return 0;
    //Your code here
  }

  public int getMaximumCuts(int[] cuts,int size,int length)
  {
    if(length==0 && size ==0 )
    {
      return Integer.MIN_VALUE;
    }
    if(length==0)
    {
      return 0;
    }

    if(size==0)
    {
      return Integer.MIN_VALUE;
    }

    if (dp[size][length] == -1) {
      if (cuts[size - 1] <= length) {
        dp[size][length] = Math.max(1+
            getMaximumCuts(cuts, size, length - cuts[size - 1]),
            getMaximumCuts(cuts, size - 1, length));
        return dp[size][length];
      }else
      {
        dp[size][length] = getMaximumCuts(cuts,size-1,length);
        return dp[size][length];
      }

    }
    else
    {
      return dp[size][length];
    }

  }

}
