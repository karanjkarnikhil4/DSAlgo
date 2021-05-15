package org.coding.dynamicProgramming.countPalindromcSubSequences;

import java.util.Arrays;
import java.util.Scanner;

public class CountPalinDromicSubSequences {

  /*You are required to complete below method */
  static class GfG {

    public void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      sc.nextLine();
      while (t > 0) {
        String str = sc.nextLine();
        // System.out.println(str.length());
        GfG g = new GfG();
        System.out.println(g.countPS(str));
        t--;
      }
    }
    private static int longesPalindromicSubSequence(
        int startIndex, int endIndex, char[] inputStringArray, int[][] cache) {
      if (startIndex == endIndex) {
        return 1;
      }

      if (startIndex > endIndex) {
        return 0;
      }

      if (cache[startIndex][endIndex] == -1) {

        if (inputStringArray[startIndex] == inputStringArray[endIndex]) {
          cache[startIndex][endIndex] =
              2
                  + longesPalindromicSubSequence(
                      startIndex + 1, endIndex - 1, inputStringArray, cache);
          return cache[startIndex][endIndex];
        } else {
          cache[startIndex][endIndex] = longesPalindromicSubSequence(startIndex + 1, endIndex, inputStringArray, cache)+
                  longesPalindromicSubSequence(startIndex, endIndex - 1, inputStringArray, cache);
          return cache[startIndex][endIndex];
        }
      } else {
        return cache[startIndex][endIndex];
      }
    }

    int countPS(String str) {
      // Your code here
      if (str != null) {

        int[][] cache = new int[str.length()][str.length()];
        for (int[] cacheRow : cache) {
          Arrays.fill(cacheRow, -1);
        }
        return longesPalindromicSubSequence(0, str.length() - 1, str.toCharArray(), cache);
      } else {
        return 0;
      }
    }
  }

}
