package org.coding.sorting.mergeSort;

// { Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
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
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();


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
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        if(l < r)
        {
            int mid = l +((r-l)/2);
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }

    }
    void merge(int arr[], int l, int m, int r)
    {
        // Your code here
        int[] aux = new int[r-l+1];
        int arr1P1 =l;
        int arr1P2 =m+1;
        int auxPointer =0;

        while (arr1P1 <= m && arr1P2 <=r) {
            if(arr[arr1P1] <= arr[arr1P2])
            {
                aux[auxPointer++] = arr[arr1P1++];

            }
            else
            {
                aux[auxPointer++] = arr[arr1P2++];
            }
        }
        while (arr1P1<=m)
        {
            aux[auxPointer++] = arr[arr1P1++];
        }

        while (arr1P2<=r)
        {
            aux[auxPointer++] = arr[arr1P2++];
        }

        auxPointer = 0;
        int start = l;
        while(auxPointer < aux.length)
        {
            arr[start++] = aux[auxPointer++];
        }
    }
}