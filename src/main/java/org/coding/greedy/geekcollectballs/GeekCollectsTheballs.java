package org.coding.greedy.geekcollectballs;

// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG{
  public static void main(String args[])throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while(t-- > 0){
      String arr[] = in.readLine().trim().split("\\s+");
      int N = Integer.parseInt(arr[0]);
      int M = Integer.parseInt(arr[1]);
      String arr1[] = in.readLine().trim().split("\\s+");
      String arr2[] = in.readLine().trim().split("\\s+");
      int a[] = new int[N];
      int b[] = new int[M];
      for(int i = 0;i < N;i++)
        a[i] = Integer.parseInt(arr1[i]);
      for(int i = 0;i < M;i++)
        b[i] = Integer.parseInt(arr2[i]);

      Solution ob = new Solution();
      System.out.println(ob.maxBalls(N, M, a, b));
    }
  }
}// } Driver Code Ends


//User function Template for Java

class Solution{
  static int maxBalls(int N, int M, int a[], int b[])
  {
    int i =0;
    int j  = 0;
    int lasti = -1;
    int lastj = -1;
    int totalSum =0;

    int NMax =0;
    int MMax =0;

    while (i < N || j < M) {
      if (i < N && lasti != i) {
        NMax += a[i];
      }

      if (j < M && lastj != j) {
        MMax += b[j];
      }
      lasti = i;
      lastj = j;

      if (i < N && j < M) {
        if (a[i] == b[j]) {
          totalSum += Math.max(NMax, MMax);
          NMax = 0;
          MMax = 0;
          if(i+1< N && a[i+1] ==b[j])
          {
            i++;
          }
          else if(j+1 <M && b[j+1]==a[i])
          {
            j++;
          }
          else
          {
            i++; j++;
          }
        } else if (a[i] > b[j]) {
          j++;
        } else {
          i++;
        }
      }
      else if(i<N)
      {
        i++;
      }
      else if (j < M)
            {
              j++;
            }
    }
    totalSum+=Math.max(NMax,MMax);
    // code here
    return totalSum;
  }
}
