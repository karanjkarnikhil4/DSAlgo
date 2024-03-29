package org.coding.arrays.moveAllZeroesToTheEndOfTheArray;// { Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr, int n) {
        // code here

        int start =-1;
        for(int i =0; i< n ; i++)
        {
            if(arr[i]!=0)
            {
                start++;
                swap(arr,start,i);
            }
        }

    }

    private void swap(int[] arr, int start, int pointer)
    {
        int temp = arr[start];
        arr[start] =arr[pointer];
        arr[pointer]= temp;

    }
}