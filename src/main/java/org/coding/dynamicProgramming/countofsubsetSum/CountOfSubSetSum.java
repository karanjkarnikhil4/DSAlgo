package org.coding.dynamicProgramming.countofsubsetSum;

import java.util.Arrays;

public class CountOfSubSetSum {

  private static int[][] t;

  // Driver code
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5};
    int sum = 10;
    int n = arr.length;
    t = new int[n + 1][sum + 1];
    for(int[] trow: t)
    {
      Arrays.fill(trow,-1);
    }
    System.out.println(countOfSubsetSum(arr, n, sum));
  }

  private static int countOfSubsetSum(int[] arr, int n, int sum) {

    if (sum == 0) {
      return 1;
    }

    if (n == 0) {
      return 0;
    }

    if (t[n][sum] == -1) {

      if (arr[n - 1] <= sum) {
        t[n][sum] =
            countOfSubsetSum(arr, n - 1, sum - arr[n - 1]) + countOfSubsetSum(arr, n - 1, sum);
        return t[n][sum];
      } else {
        t[n][sum] = countOfSubsetSum(arr, n - 1, sum);
        return t[n][sum];
      }
    } else {
      return t[n][sum];
    }
  }
}
