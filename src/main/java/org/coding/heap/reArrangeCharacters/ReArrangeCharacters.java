package org.coding.heap.reArrangeCharacters;
/*package whatever //do not write package name here */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;

class GFG {
  public static void main(String[] args) throws IOException {
    // code
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String s[] = read.readLine().split("");
      isReArrangementPossible(s);
    }
    }

  private static void isReArrangementPossible(String[] args) {
    HashMap<String, Integer> hashMap = new HashMap<>();
    int maxFrequency=0;
    if (args.length > 0) {
      maxFrequency = 1;
    }

    for (int i = 0; i < args.length; i++) {
      if (hashMap.containsKey(args[i])) {
        int frequency = hashMap.get(args[i]) + 1;
        hashMap.put(args[i], frequency);
        if (frequency > maxFrequency) {
          maxFrequency = frequency;
        }
      } else {
        hashMap.put(args[i], 1);
      }
    }

    if (maxFrequency <= args.length - maxFrequency+1) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }
  }
}
