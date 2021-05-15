package org.coding.heap.medianinastream;

// { Driver Code Starts

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Driverclass {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    int n;
    while (t-- > 0) {
      n = sc.nextInt();

      FindMedian Ans = new FindMedian();
      for (int i = 1; i <= n; i++) {
        int x = sc.nextInt();
        Ans.insertHeap(x);
        System.out.println((int) Math.floor(Ans.getMedian()));
      }
    }
  }
}

// } Driver Code Ends

class FindMedian {
  static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
  static PriorityQueue<Integer> min = new PriorityQueue<>();

  // Function to insert heap
  public static void insertHeap(int x) {
    // add your code here
    if (max.isEmpty()) {
      max.add(x);
    } else if (!max.isEmpty()) {
      if (x <= max.peek()) {
        max.add(x);
        if (isTreeImBalanced()) {
          balanceHeaps();
        }
      } else {
        min.add(x);
        if (isTreeImBalanced()) {
          balanceHeaps();
        }
      }
    }
  }

  private static boolean isTreeImBalanced() {
    return (Math.abs(max.size() - min.size()) > 1);
  }

  // Function to balance Heaps
  public static void balanceHeaps() {
    if (max.size() > min.size()) {
      min.add(max.poll());
    } else {
      max.add(min.poll());
    }
  }
  // add your code here

  // function to getMedian
  public static double getMedian() {
    if (max.size() == min.size()) {
      return (max.peek() + min.peek()) / 2;
    } else if (max.size() > min.size()) {
      return max.peek();
    } else {
      return min.peek();
    }
  }
}
