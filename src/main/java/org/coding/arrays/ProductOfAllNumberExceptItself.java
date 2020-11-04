package org.coding.arrays;/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ProductOfAllNumberExceptItself {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String inputLine;
            String[] input;
            inputLine = br.readLine().trim();
            int n = Integer.parseInt(inputLine);
            int[] arr = new int[n];
            input = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            getProductOfAllNumbersArray(arr);

        }
    }

    private static void getProductOfAllNumbersArray(int[] arr) {

        int[] leftArray = new int[arr.length];
        int[] rightArray = new int[arr.length];
        int[] resultArray = new int[arr.length];

        leftArray[0] =1;
        rightArray[arr.length-1] = 1;

        for(int i = 0 ; i < arr.length-1 ; i++)
        {
            leftArray[i+1] = arr[i]* leftArray[i];
        }

        for(int k = arr.length -1 ; k >=1 ; k--)
        {
            rightArray[k-1] = arr[k]* rightArray[k];
        }

        for(int j =0; j < arr.length; j++)
        {
            resultArray[j] = leftArray[j] * rightArray[j];
        }

        printArray(resultArray);
    }

    private static void printArray(int[] arr)
    {
        for (int i:
        arr) {
            System.out.print(i+" ");
        }
        System.out.println("");
    }
}