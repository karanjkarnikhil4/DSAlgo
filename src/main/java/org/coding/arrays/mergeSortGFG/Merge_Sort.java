package org.coding.arrays.mergeSortGFG;// { Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        int n = arr.length;
      for (int i = 0; i < n; ++i) {
        System.out.print(arr[i] + " ");
      }
        System.out.println();
    }



	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);

		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();

			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();

			//creating an array of size n
			int arr[] = new int[n];

			//adding elements to the array
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }


			Solution g = new Solution();

			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}


// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
      int startIndex = l;
      int low2 = m+1;
      int[] mergedArray = new int[r-l+1];
      int mergedArrayIndex = 0;
      while(l<=m && low2 <=r)
      {
        if(arr[l] <= arr[low2])
        {
          mergedArray[mergedArrayIndex] = arr[l];
          l++;
        }
        else
        {
          mergedArray[mergedArrayIndex] = arr[low2];
          low2++;
        }
        mergedArrayIndex++;
      }

      while(l <=m)
      {
        mergedArray[mergedArrayIndex] = arr[l];
        l++;
        mergedArrayIndex++;
      }
      while(low2 <=r)
      {
        mergedArray[mergedArrayIndex] = arr[low2];
        low2++;
        mergedArrayIndex++;
      }

      for(int i =startIndex,j=0;i<=r;i++,j++)
      {
        arr[i] = mergedArray[j];
      }
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
      if(l >= r)
      {
        return;
      }

      else
      {
        int mid = l + ((r-l)/2);
        int nextLower = mid+1;
        mergeSort(arr,l,mid);
        mergeSort(arr,nextLower,r);
        merge(arr, l,mid,r);
      }
    }
}