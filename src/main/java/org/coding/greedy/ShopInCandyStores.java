package org.coding.greedy;

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class GFG {

  public static void main(String[] args) throws IOException {
    // code
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // testcases
    int t = Integer.parseInt(br.readLine().trim());

    while (t-- > 0) {
      String[] NAndK = br.readLine().trim().replaceAll("\\s+"," ").split(" ");
      // size of array

      int N = Integer.parseInt(NAndK[0]);

      int K = Integer.parseInt(NAndK[1]);

      // adding elements to arrays start and end
      String[] input = br.readLine().trim().replaceAll("\\s+"," ").split(" ");
      int[] candiesCost = new int[N];
      for (int i = 0; i < N; i++) candiesCost[i] = Integer.parseInt(input[i]);

      CandiesCost candiesMinMaxCost = getMinAndMaxAmount(N, K, candiesCost);
      System.out.println(candiesMinMaxCost.min + " " + candiesMinMaxCost.max);
    }
  }

  private static CandiesCost getMinAndMaxAmount(int n, int k, int[] candiesCost) {

    Arrays.sort(candiesCost);
    int minCost = 0;
    int maxCost = 0;

    int i = 0;
    int j = n-1;

    while(i<=j)
    {
      minCost+= candiesCost[i];
      i++;
      j-=k;
    }

    i =0;
    j = n-1;

    while(i<=j)
    {
      maxCost+= candiesCost[j];
      i+=k;
      j--;
    }
    return new CandiesCost(minCost, maxCost);
  }

  static class CandiesCost {
    int min;
    int max;

    public CandiesCost(int min, int max) {
      this.min = min;
      this.max = max;
    }

    public int getMin() {
      return min;
    }

    public int getMax() {
      return max;
    }
  }
}
