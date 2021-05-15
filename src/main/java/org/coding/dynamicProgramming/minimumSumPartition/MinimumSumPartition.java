package org.coding.dynamicProgramming.minimumSumPartition;

// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-->0)
    {
      int n = sc.nextInt();
      int A[] = new int[n];
      for(int i = 0;i<n;i++)
        A[i] = sc.nextInt();
      Solution ob = new Solution();
      System.out.println(ob.minDiffernce(A,n));
    }
  }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
  static boolean[][] t ;
  public int minDiffernce(int arr[], int n)
  {
    // Your code goes here
     int sum = Arrays.stream(arr).sum();
      t= new boolean[n+1][sum+1];

     isSubsetSum(arr,n,sum);
     List<Integer> list = new ArrayList<>();

     for(int range =0; range<= sum/2; range++)
     {
       if(t[n][range])
       {
         list.add(range);
       }
     }

     int min = Integer.MAX_VALUE;

     for(int i : list)
     {
       min = Math.min(min,(sum-(2*i)));
     }

     return min;

  }

  private static boolean isSubsetSum(int[] set, int n, int sum) {



    for(int i =0; i< n+1; i++ )
    {
      for(int j =0; j < sum+1; j++)
      {
        if(i ==0)
        {
          t[i][j] = false;
        }

        if(j==0)
        {
          t[i][j] = true;
        }
      }
    }

    for(int i =1; i< n+1; i++ )
    {
      for(int j=1; j< sum+1; j++)
      {
        if(set[i-1] <=j)
        {
          t[i][j] = t[i-1][j-set[i-1]] || t[i-1][j];
        }

        else
        {
          t[i][j] = t[i-1][j];
        }
      }
    }

    return t[n][sum];


  }
}