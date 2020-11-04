package org.coding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SingleNumberPrepTech {

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

            int singleNumber = search(arr, n);

            System.out.println(singleNumber);
        }
    }

    private  static int search(int A[], int N)
    {
        if(A.length == 1)
            return A[0];

        int number = A[0];

        for(int i =1; i< N ; i ++ )
        {
            number = number ^ A[i];
        }

        return number;
    }
}
