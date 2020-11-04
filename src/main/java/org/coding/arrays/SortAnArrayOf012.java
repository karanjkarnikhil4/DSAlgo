package org.coding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortAnArrayOf012 {

    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
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


        if (arr == null || arr.length == 1) {
            return;
        }

        int startPointer = -1;
        int endPointer = arr.length;

        int iterator = 0;

        while (iterator < endPointer) {

            if (arr[iterator] == 0) {
                startPointer++;
                swamp(startPointer, iterator, arr);
                iterator++;
            }

            else if (arr[iterator] == 1) {
                iterator++;
            }

            else if (arr[iterator] == 2) {
                endPointer--;
                swamp(endPointer, iterator, arr);
            }
        }


    }

    private static void swamp(int index1, int index2, int[] arr) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
