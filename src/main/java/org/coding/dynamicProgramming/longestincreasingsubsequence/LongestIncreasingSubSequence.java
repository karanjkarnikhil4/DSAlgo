package org.coding.dynamicProgramming.longestincreasingsubsequence;

// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
  public static void main(String args[]) throws IOException {

    //taking input using Scanner class
    Scanner sc = new Scanner(System.in);

    //taking total testcases
    int t = sc.nextInt();
    while(t > 0){

      //taking size of array
      int n = sc.nextInt();
      int array[] = new int[n];

      //inserting elements in the array
      for (int i = 0; i < n; ++i)
      {
        array[i] = sc.nextInt();
      }

      //creating an object of class Solution
      Solution ob = new Solution();

      //calling longestSubsequence() method of class
      //Solution
      System.out.println(ob.longestSubsequence(n,array));
      t--;
    }
  }
} // } Driver Code Ends


class Solution {
  // return length of longest strictly increasing subsequence
  static int longestSubsequence(int size, int a[]){

    if(a.length==0)
    {
      return 0;
    }

    if(a.length==1){
      return 1;
    }

    int max =1;

    int[] dpArray = new int[size];

    for(int k =0; k< size; k++)
    {
      dpArray[k] =1;
    }

    for(int j =1; j< size; j++)
    {
      for(int i =0; i< j; i++)
      {
         if( a[j] > a[i] && dpArray[j]<=dpArray[i])
         {
           dpArray[j] =dpArray[i]+1;
           if( dpArray[j]  >max)
           {
             max = dpArray[j];
           }
         }
      }
    }

return max;


  }
}
