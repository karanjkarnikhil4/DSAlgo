package org.coding.arrays.subarrayWithGivenSum;

// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();

    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      int s = sc.nextInt();

      int[] m = new int[n];
      for (int j = 0; j < n; j++) {
        m[j] = sc.nextInt();
      }

      Solution obj = new Solution();
      ArrayList<Integer> res = obj.subarraySum(m, n, s);
      for(int ii = 0;ii<res.size();ii++)
        System.out.print(res.get(ii) + " ");
      System.out.println();
    }
  }

}// } Driver Code Ends



class Solution
{
  //Function to find a continuous sub-array which adds up to a given number.
  static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
  {
    // Your code here

    int startIndex = 0;
    int endIndex =0;
    long sum =0;
    ArrayList<Integer> indexList = new ArrayList<>();

    while(endIndex < n || startIndex < n)
    {
      if(sum< s  && endIndex < n)
      {
        sum+=arr[endIndex];
        endIndex++;
        if(sum==s)
        {
          indexList.add(startIndex+1);
          indexList.add(endIndex);
          break;
        }

      }
      else if( sum > s)
      {
        sum-=arr[startIndex];
        startIndex++;
        if(sum==s)
        {
          indexList.add(startIndex+1);
          indexList.add(endIndex);
          break;
        }

      }
      else
      {
        break;
      }
    }

    if(indexList.size() ==0)
    {
      indexList.add(-1);
    }

    return  indexList;
  }
}