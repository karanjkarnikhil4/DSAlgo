package org.coding.greedy.LargestNumberPossible;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
  public static void main(String args[])throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while(t-- > 0){
      String a[] = in.readLine().trim().split("\\s+");
      int N = Integer.parseInt(a[0]);
      int S = Integer.parseInt(a[1]);

      Solution ob = new Solution();
      System.out.println(ob.findLargest(N, S));
    }
  }
}// } Driver Code Ends


//User function Template for Java

class Solution{


  static String findLargest(int N, int S){

    if(N==0)
    {
      return "-1";
    }
    if(S==0 && N >1)
    {
      return "-1";
    }
    // code here
    StringBuilder stringBuilder = new StringBuilder();
    for(int i=0; i<N; i++)
    {
      for(int j =9; j>= 0; j--)
      {
        if(j<= S)
        {
          stringBuilder.append(j);
          S=S-j;
          break;
        }
      }
    }
    if(S!=0)
    {
      return "-1";
    }
    return  stringBuilder.toString();

  }
}