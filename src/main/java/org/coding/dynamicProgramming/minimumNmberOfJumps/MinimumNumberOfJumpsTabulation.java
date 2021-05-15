package org.coding.dynamicProgramming.minimumNmberOfJumps;

// { Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG1
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
      System.out.println(new solve1().minJumps(arr));
    }
  }

}
// } Driver Code Ends


class solve1{
  static int minJumps(int[] arr){

//    if(arr.length ==0)
//    {
//      return -1;
//    }
//
//    if(arr[0] ==0)
//    {
//      return -1;
//    }
//
//    int[] minJumpArray = new int[arr.length];
//    Arrays.fill(minJumpArray,-1);
//    minJumpArray[0] =0;
//
//    for(int j =1; j < arr.length; j++)
//    {
//      for(int i =0; i < j; i++)
//      {
//          if(j-i <= arr[i] && minJumpArray[i] !=-1)
//          {
//            if(minJumpArray[j]==-1)
//            {
//              minJumpArray[j] = minJumpArray[i]+1;
//            }
//            else
//            {
//              minJumpArray[j] = Math.min(minJumpArray[j]+1, minJumpArray[j]);
//            }
//          }
//      }
//    }
//    return minJumpArray[arr.length-1];
// jumps[n-1] will hold the
    int n =arr.length;
    int jumps[] = new int[n];
    // result
    int i, j;

    // if first element is 0,
    if (n == 0 || arr[0] == 0)
      return -1;
    // end cannot be reached

    jumps[0] = 0;

    // Find the minimum number of jumps to reach arr[i]
    // from arr[0], and assign this value to jumps[i]
    for (i = 1; i < n; i++) {
      jumps[i] = Integer.MAX_VALUE;
      for (j = 0; j < i; j++) {
        if (i <= j + arr[j]
            && jumps[j]
            != Integer.MAX_VALUE) {
          jumps[i] = Math.min(jumps[i], jumps[j] + 1);
          break;
        }
      }
    }
    return jumps[n - 1]==Integer.MAX_VALUE?-1:jumps[n-1];


  }
}