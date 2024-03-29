package org.coding.heap.HeapSort; // { Driver Code Starts

import java.util.Scanner;

class Heap_Sort {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    Heap_Sort hs = new Heap_Sort();
    int arr[] = new int[1000000];
    int T = sc.nextInt();
    while (T > 0) {
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
      hs.heapSort(arr, n);
      hs.printArray(arr, n);
      T--;
    }
  }

  void printArray(int arr[], int n) {
    // int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }

  public void heapSort(int arr[], int n) {
    GfG g = new GfG();
    g.buildHeap(arr, n);
    for (int i = n - 1; i >= 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      g.heapify(arr, i, 0);
    }
  }
}

// } Driver Code Ends

class GfG {
  void buildHeap(int arr[], int n) {
    for (int i = (n - 1) / 2; i >= 0; i--) {
      heapify(arr, n, i);
    }
  }

  // To heapify a subtree rooted with node i which is
  // an index in arr[]. n is size of heap
  void heapify(int arr[], int n, int i) {
    // Your code here
    int index = i;
    int smallest = i;
    int lIndex = 2 * i + 1;
    int rIndex = 2 * i + 2;

    if (lIndex <= n - 1 && arr[lIndex] > arr[smallest]) {
      smallest = lIndex;
    }
    if (rIndex <= n - 1 && arr[rIndex] > arr[smallest]) {
      smallest = rIndex;
    }

    if (smallest != index) {
      int temp = arr[smallest];
      arr[smallest] = arr[index];
      arr[index] = temp;
      heapify(arr, n, smallest);
    }
  }
}
