package org.coding.arrays.mergeSort;

public class MergeSort {

  public static void main(String[] args) {
 int[] integerArray ={5, 2, 6, 10};
    MergeSort.sort(integerArray,4);
    for (int i : integerArray) {
      System.out.println(i);
    }
  }

  public static void sort(int[] arr,int length)
  {
    divide(arr,0,length-1);
  }

  private static void divide(int[] arr, int l, int r)
  {
    if(l >= r)
    {
      return;
    }

    else
    {
      int mid = l + ((r-l)/2);
      int nextLower = mid+1;
      divide(arr,l,mid);
      divide(arr,nextLower,r);
      merge(arr, l,mid,r);
    }
  }

  private static void merge(int[] arr, int low,int mid,  int high)
  {
    int k = low, i = low, j = mid + 1;
    int[] aux = new int[high-low+1];

    while (i <= mid && j <= high)
    {
      if (arr[i] <= arr[j]) {
        aux[k++] = arr[i++];
      }
      else {
        aux[k++] = arr[j++];
      }
    }
    while (i <= mid) {
      aux[k++] = arr[i++];
    }

    for (i = low; i <= high; i++) {
      arr[i] = aux[i];
    }
  }

}
