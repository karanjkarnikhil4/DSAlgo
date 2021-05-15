package org.coding.dynamicProgramming;
// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
  int x;
  int y;

  public Pair(int a, int b)
  {
    x = a;
    y = b;
  }
}

class Chainlength
{
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while(t-- > 0)
    {
      int n = sc.nextInt();
      Pair pr[] = new Pair[n];
      int arr[] = new int[2*n];
      for(int i = 0; i < 2*n; i++)
      {
        arr[i] = sc.nextInt();
      }
      for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
      {
        pr[j] = new Pair(arr[i], arr[i+1]);
      }
      GfG g = new GfG();
      g.maxChainLength(pr, n);
    }
  }
}
// } Driver Code Ends


/*class CompareByFirst implements Comparator<Pair>
{
   public int compare(Pair a, Pair b)
    {
        return a.x - b.x;
    }
}*/

class GfG
{
  int maxLength = 0;
   int maxChainLength(Pair arr[], int n)
  {
    Set<Pair> pairSet = new HashSet<>();
     maxLengthOfChain(arr,n,pairSet, null);
     return maxLength;
  }

  void maxLengthOfChain(Pair arr[], int n,Set<Pair> pairSet,Pair lastPair)
  {

    if (lastPair == null) {
      for (int i = 0; i < n; i++) {
        pairSet.add(arr[i]);
        maxLengthOfChain(arr,n,pairSet,arr[i]);
        maxLength = Math.max(maxLength,pairSet.size());
        pairSet.remove(arr[i]);
      }
    }
    else
    {
      for (int i = 0; i < n; i++) {
        if(!pairSet.contains(arr[i]) && arr[i].x> lastPair.y)
        {
          pairSet.add(arr[i]);
          maxLengthOfChain(arr,n, pairSet,arr[i]);
          maxLength = Math.max(maxLength,pairSet.size());
          pairSet.remove(arr[i]);
        }
      }
    }
  }
}
