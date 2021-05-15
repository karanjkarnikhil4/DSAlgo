package org.coding.greedy.CoinPiles;

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
  public static void main (String[] args) throws IOException {
    //code
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //testcases
    int t = Integer.parseInt(br.readLine().trim());

    while(t-- > 0)
    {
      String inputLine[] = br.readLine().trim().split(" ");
      //size of array
      int n = Integer.parseInt(inputLine[0]);
      int k = Integer.parseInt(inputLine[1]);

      int coinPiles[] = new int[n];

      //adding elements to arrays start and end
      inputLine = br.readLine().trim().split(" ");
      for(int i = 0; i < n; i++)
        coinPiles[i] = Integer.parseInt(inputLine[i]);
      Arrays.sort(coinPiles);
      System.out.println(getMinimumCoinsToBeRemoved(coinPiles,k,n,0));

  }
    }

    private static int getMinimumCoinsToBeRemoved(int[] coinpiles, int k, int n,int startIndex)
    {
       if(startIndex == n-1){
         return 0;
       }
        int firstItem = coinpiles[startIndex];
        int minCoinsSum = 0;
        for(int i =startIndex+1; i< n; i++)
        {
           if(coinpiles[i]-firstItem > k)
           {
                minCoinsSum +=(coinpiles[i]-firstItem)-k;
           }
        }
        if(firstItem < minCoinsSum)
        {
            return Math.min(minCoinsSum,firstItem + getMinimumCoinsToBeRemoved(coinpiles, k ,n, startIndex+1));
        }
        else
        {
          return minCoinsSum;
        }
    }

}