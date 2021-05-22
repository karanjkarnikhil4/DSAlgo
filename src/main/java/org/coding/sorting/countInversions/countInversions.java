package org.coding.sorting.countInversions;

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for(long i = 0; i < n; i++)
                arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, n));

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{

    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here

        return mergeSort(arr, 0, N-1);

    }


   static long mergeSort(long arr[], long l, long r)
    {
        long countInversions =0;
        //code here
        if(l < r)
        {
            long mid = l +((r-l)/2);
            countInversions+= mergeSort(arr,l,mid);
            countInversions+= mergeSort(arr,mid+1,r);
            countInversions+= merge(arr,l,mid,r);
        }
        return countInversions;
    }
    static long  merge(long arr[], long l, long m, long r)
    {
        // Your code here
        long countInversions =0;
        long[] aux = new long[(int) (r-l+1)];
        long arr1P1 =l;
        long arr1P2 =m+1;
        long auxPointer =0L;

        while (arr1P1 <= m && arr1P2 <=r) {
            if(arr[(int) arr1P1] <= arr[(int) arr1P2])
            {
                aux[(int) auxPointer++] = arr[(int) arr1P1++];

            }
            else
            {
                countInversions+= m-arr1P1+1;
                aux[(int) auxPointer++] = arr[(int) arr1P2++];
            }
        }
        while (arr1P1<=m)
        {
            aux[(int) auxPointer++] = arr[(int) arr1P1++];
        }

        while (arr1P2<=r)
        {
            aux[(int) auxPointer++] = arr[(int) arr1P2++];
        }

        auxPointer = 0;
        long start = l;
        while(auxPointer < aux.length)
        {
            arr[(int) start++] = aux[(int) auxPointer++];
        }

        return countInversions;
    }
}