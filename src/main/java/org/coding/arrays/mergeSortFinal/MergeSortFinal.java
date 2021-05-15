package org.coding.arrays.mergeSortFinal;

import java.util.Arrays;

class Main
{
  public static void merge(int[] arr, int l, int m, int r)
  {
    int[] aux = new int[r-l+1];
    int i = l, j = m + 1;
    int index =0;
    while (i <= m && j <= r)
    {
      if (arr[i] <= arr[j]) {
        aux[index++] = arr[i++];
      }
      else {
        aux[index++] = arr[j++];
      }
    }
    while (i <= m) {
      aux[index++] = arr[i++];
    }

    while (j <= r) {
      aux[index++] = arr[j++];
    }

    for (i = l,j=0; i <= r; i++,j++) {
      arr[i] = aux[j];
    }
  }

  // Sort array arr [l..r] using auxiliary array aux
  public static void mergeSort(int[] arr, int l, int r)
  {
    // Base case
    if (r == l) {	// if run size == 1
      return;
    }

    // find mid point
    int mid = (l + ((r - l) >> 1));

    // recursively split runs into two halves until run size == 1,
    // then merge them and return back up the call chain

    mergeSort(arr, l, mid);	  // split / merge left  half
    mergeSort(arr, mid + 1, r); // split / merge right half

    merge(arr, l, mid, r);	// merge the two half runs
  }

  // Function to check if arr is sorted in ascending order or not
  public static boolean isSorted(int[] arr)
  {
    int prev = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (prev > arr[i]) {
        System.out.println("MergeSort Fails!!");
        return false;
      }
      prev = arr[i];
    }

    return true;
  }


  public static void main(String[] args)
  {
    int[] arr = {8,4,3,12,25,6,13,10};

    // sort array 'arr' using auxiliary array 'aux'
    mergeSort(arr,0, arr.length - 1);

   // if (isSorted(arr)) {
      System.out.println(Arrays.toString(arr));
   // }
  }
}

/* Try more Inputs
case 1:
int[] aux = Arrays.copyOf(arr, arr.length);
actual = mergeSort([38, 27, 43, 3, 9, 82, 10],aux,0,6)
expected = [3,9,10,27,38,43,82]

case2: 
int[] aux = Arrays.copyOf(arr, arr.length);
 actual = mergeSort([12, 11, 13, 5, 6, 7 ],aux,0,5)
 expected = [5, 6, 7, 11, 12, 13]
 
case3: 
int[] aux = Arrays.copyOf(arr, arr.length);
actual = mergeSort([3,2,1,4],aux,0,3)
expected = [1,2,3,4]
*/