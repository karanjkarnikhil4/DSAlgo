package org.coding.dynamicProgramming.rotCutting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {

  public static void main(String[] args) throws IOException {
    //
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {

      int sizeOfArray = Integer.parseInt(br.readLine().trim());

      int[] priceArray = new int[sizeOfArray];
      int[] dp = new int[sizeOfArray];

      String[] array = br.readLine().split(" ");
      for (int i = 0; i < sizeOfArray; i++) {
        priceArray[i] = Integer.parseInt(array[i]);
        dp[i] = -1;
      }
      System.out.println(maximumPriceObtained(sizeOfArray, priceArray, dp));
      ;
    }
  }

  public static int maximumPriceObtained(int length, int[] priceArray, int[] dp) {
    if (length == 0) return 0;

    if (dp[length - 1] == -1) {

      int max = 0;
      for (int i = 1; i <= length; i++) {
        max = Math.max(max, priceArray[i - 1] + maximumPriceObtained(length - i, priceArray, dp));
      }
      dp[length - 1] = max;
      return max;
    } else {
      return dp[length - 1];
    }
  }
}
