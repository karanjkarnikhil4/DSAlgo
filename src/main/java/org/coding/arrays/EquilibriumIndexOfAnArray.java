package org.coding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibriumIndexOfAnArray {

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

            int majorityElement = getEquilibriumPoint(arr, n);

            System.out.println(majorityElement);
        }
    }

    private static int getEquilibriumPoint(int[] arr, int n) {

        if(n== 1)
        {
            return arr[0];
        }

        int totalSum =0;
        int leftSum =0;
        Integer equilibriumPoint = -1;

        for (int i =0; i < arr.length; i++)
        {
            totalSum = totalSum+arr[i];
        }

        for (int j =0; j < arr.length; j++)
        {
            int rightSum = totalSum - leftSum- arr[j];

            if(rightSum == leftSum)
            {
                  equilibriumPoint = j+1;
                  break;
            }

            leftSum = leftSum+arr[j];
        }

        return equilibriumPoint;
    }
}
