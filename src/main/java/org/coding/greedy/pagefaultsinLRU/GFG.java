package org.coding.greedy.pagefaultsinLRU;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class GFG {

  public static void main(String[] args) throws IOException {
    // code
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // testcases
    int t = Integer.parseInt(br.readLine().trim());

    while (t-- > 0) {
      Integer pageRequests = Integer.parseInt(br.readLine());
      // size of array

      int pages[] = new int[pageRequests];

      // adding elements to arrays start and end
      String[] inputLine = br.readLine().trim().split(" ");
      for (int i = 0; i < pageRequests; i++) pages[i] = Integer.parseInt(inputLine[i]);

      Integer memorySize = Integer.parseInt(br.readLine());

      System.out.println(new GFG().getPageFaults(pages, pageRequests, memorySize));
    }
  }

  private int getPageFaults(int[] pages, Integer pageRequests, Integer memorySize) {

    int numberOfPageFaults = 0;
    Deque<Integer> deque = new ArrayDeque<>(memorySize);

    for (int i = 0; i < pages.length; i++) {
      if (deque.size() < memorySize && !deque.contains(pages[i])) {
        deque.addFirst(pages[i]);
        numberOfPageFaults++;
      } else if (!deque.contains(pages[i]) && deque.size() == memorySize) {
        deque.removeLast();
        deque.push(pages[i]);
        numberOfPageFaults++;
      } else {
        deque.remove(pages[i]);
        deque.push(pages[i]);
      }
    }
    return numberOfPageFaults;
  }

}
