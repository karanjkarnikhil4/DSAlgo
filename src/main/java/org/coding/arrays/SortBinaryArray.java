package org.coding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortBinaryArray {

    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            sortArray(arr, n);
            print(arr);
        }
    }

    private static void sortArray(int[] arr, int n) {

        int startPointer = -1;
        for(int i =0; i<n; i ++)
        {
            if(arr[i] ==0)
            {
                startPointer++;
                swap(startPointer, i, arr);
            }
        }
    }

    private static  void print (int[] arr)
    {
        for(int i =0; i< arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

    private static void swap (int firstIndex, int secondIndex,int[] arr)
    {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

}
