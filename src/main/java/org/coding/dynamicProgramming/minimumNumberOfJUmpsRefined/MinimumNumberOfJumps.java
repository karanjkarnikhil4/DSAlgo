package org.coding.dynamicProgramming.minimumNumberOfJUmpsRefined;

// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
  public static void main (String[] args) throws IOException
  {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    while(t-- > 0){
      int size = Integer.parseInt(br.readLine());
      String[] arrStr = ((String)br.readLine()).split("\\s+");
      int[] arr= new int[size];
      for(int i = 0;i<size;i++){
        arr[i] = Integer.parseInt(arrStr[i]);
      }

      System.out.println(new solve().minJumps(arr));

    }
  }

}
// } Driver Code Ends


class solve{

  private static   int[] dp;
  static int minJumps(int[] arr){
    // your code here
    dp = new int[arr.length+1];
    Arrays.fill(dp,0);

   return getMinJumps(1,arr, arr.length);
  }

  private static int getMinJumps(int startIndex, int[] arr, int length) {

    if(startIndex == length)
    {
      return 0;
    }

    int min = Integer.MAX_VALUE-1;
    if (dp[startIndex] == 0) {

      for (int i = 1; i <= arr[startIndex - 1]; i++) {
        if (startIndex + i <= length) {
          int jumps = 1 + getMinJumps(startIndex + i, arr, length);
          min = Math.min(min, jumps);
        }
      }

      dp[startIndex] =  (min >= Integer.MAX_VALUE-1)? -1 : min;
      return dp[startIndex];
    }

    else
    {
      return dp[startIndex];
    }
  }
}
