package org.coding.dynamicProgramming.minimumNmberOfJumps;

// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class GFG {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      int size = Integer.parseInt(br.readLine());
      String[] arrStr = ((String) br.readLine()).split("\\s+");
      int[] arr = new int[size];
      for (int i = 0; i < size; i++) {
        arr[i] = Integer.parseInt(arrStr[i]);
      }
      System.out.println(new solve().minJumps(arr));
    }
  }
}
// } Driver Code Ends

class solve {

  private static int[] dp;
  static int minJumps(int[] arr) {
    dp= new int[arr.length];
    Arrays.fill(dp,-1);
    int minJumps = getMinimumNumberOfJumps(arr, arr.length,1);

    if(minJumps>=Integer.MAX_VALUE-1)
    {
      return -1;
    }
    else
    {
      return minJumps;
    }
  }

  private static int getMinimumNumberOfJumps(int[]arr,int size,int startElement)
  {
    if(startElement == size)
    {
      return 0;
    }
    int minJumps = Integer.MAX_VALUE-1;

    if(arr[startElement-1]==0)
      return minJumps;

    if (dp[startElement - 1] == -1) {
      for (int i = 1; ((i <= (arr[startElement - 1])) && (startElement + i <= size)); i++) {
        minJumps = Math.min(minJumps, 1 + getMinimumNumberOfJumps(arr, size, startElement + i));
        dp[startElement-1] =minJumps;
      }
    }
    else
    {
      minJumps = dp[startElement-1];
    }

    return minJumps;
  }
}
