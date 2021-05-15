package org.coding.arrays.BinarySearch;// { Driver Code Starts

import java.lang.*;
import java.io.*;

public class BinarySearch
{

  public static void main(String args[])throws IOException
  {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());

    while(t-- > 0)
    {
      String s[] = read.readLine().trim().split("\\s+");

      int n = Integer.parseInt(s[0]);
      int k = Integer.parseInt(s[1]);

      int arr[] = new int[n];

      String st[] = read.readLine().trim().split("\\s+");

      for(int i = 0; i < n; i++)
      {
        arr[i] = Integer.parseInt(st[i]);
      }

      Solution obj = new Solution();

      System.out.println(obj.searchInSorted(arr, n, k));
    }
  }
}// } Driver Code Ends


class Solution{
  static int searchInSorted(int arr[], int N, int K)
  {

    // Your code here
  return BinarySearch(arr, 0,N-1,K);

  }

  static int BinarySearch(int[] arr, int low, int high, int k)
  {
    if(low==high)
    {
      if(k == arr[low])
      {
        return 1;
      }
      else
      {
        return -1;
      }
    }

    int mid = (low+high)/2;

    if(arr[mid]< k)
    {
      return BinarySearch(arr, mid+1, high,k);
    }
    else if(arr[mid]> k)
    {
      return BinarySearch(arr, low, mid-1, k);
    }
    else
      return 1;
  }

}