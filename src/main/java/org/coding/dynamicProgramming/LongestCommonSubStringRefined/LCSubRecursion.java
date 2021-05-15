package org.coding.dynamicProgramming.LongestCommonSubStringRefined;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG1
{
  public static void main(String args[]) throws IOException, IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while(t-- > 0)
    {
      String input[] = read.readLine().trim().split(" ");
      int n = Integer.parseInt(input[0]);
      int m = Integer.parseInt(input[1]);

      String S1 = read.readLine().trim();
      String S2 = read.readLine().trim();

      Solution ob = new Solution();
      System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
    }
  }
}// } Driver Code Ends


//User function Template for Java

class Solution12{
  int longestCommonSubstr(String S1, String S2, int n, int m){
    // code here
    return 0;
  }
}