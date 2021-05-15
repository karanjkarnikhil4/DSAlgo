package org.coding.dynamicProgramming.rotCutting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RodCuttingUnbounded {

  static int[][] dp;
  public static void main(String[] args) throws IOException {
    //
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {

      int sizeOfArray = Integer.parseInt(br.readLine().trim());

      int[] priceArray = new int[sizeOfArray];
      int[] lengthArray = new int[sizeOfArray];
      dp = new int[sizeOfArray+1][sizeOfArray+1];
      for(int[] array: dp)
      {
        Arrays.fill(array,-1);
      }

      String[] array = br.readLine().split(" ");
      for (int i = 0; i < sizeOfArray; i++) {
        priceArray[i] = Integer.parseInt(array[i]);
        lengthArray[i] = i + 1;
      }
      System.out.println(maximumPriceObtained(lengthArray, priceArray, sizeOfArray,sizeOfArray));
    }
  }

  public static int maximumPriceObtained(int[] availableLengths, int[] priceArray, int length,int size) {
    if (length == 0 || size ==0 ) return 0;

    if (dp[size][length] == -1) {
      if (availableLengths[size - 1] <= length) {
        dp[size][length] =
            Math.max(
                priceArray[size - 1]
                    + maximumPriceObtained(
                        availableLengths, priceArray, length - availableLengths[size - 1], size),
                maximumPriceObtained(availableLengths, priceArray, length, size - 1));
        return dp[size][length];
      } else {
        dp[size][length] = maximumPriceObtained(availableLengths, priceArray, length, size - 1);
        return dp[size][length];
      }
    }
    else
    {
      return  dp[size][length];
    }

  }
}
