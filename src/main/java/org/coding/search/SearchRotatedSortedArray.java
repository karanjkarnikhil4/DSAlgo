package org.coding.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchRotatedSortedArray {

    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int sizeOfArray = Integer.parseInt(br.readLine());
            int[] arr = new int[sizeOfArray];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int elementToBeSearched = Integer.parseInt(br.readLine());
            int elementIndex = searchRotatedArray(arr, sizeOfArray, elementToBeSearched);
            System.out.println(elementIndex);
        }
    }

    private static int searchRotatedArray(int[] arr, int sizeOfArray, int elementToBeSearched) {
        int start =0;
        int end =sizeOfArray-1;
        boolean isElementInAlpha = elementToBeSearched > arr[sizeOfArray-1];

        while(start <= end)
        {
            int midpoint = (start+end)/2;
            if(arr[midpoint] ==elementToBeSearched)
            {
                return midpoint;
            }

            if(isElementInAlpha) {
                if ((arr[midpoint] > arr[sizeOfArray - 1]) && arr[midpoint] < elementToBeSearched) {
                    start = midpoint + 1;
                } else if ((arr[midpoint] > arr[sizeOfArray - 1]) && arr[midpoint] > elementToBeSearched) {
                    end = midpoint - 1;
                }

                else if(arr[midpoint] < arr[sizeOfArray -1])
                {
                    end = midpoint-1;
                }
            }
            else {
                if ((arr[midpoint] < arr[sizeOfArray - 1]) && arr[midpoint] < elementToBeSearched) {
                    start = midpoint + 1;
                }

                if ((arr[midpoint] < arr[sizeOfArray - 1]) && arr[midpoint] > elementToBeSearched) {
                    end = midpoint - 1;
                }

                else if(arr[midpoint] > arr[sizeOfArray -1])
                {
                    start = midpoint+1;
                }
            }
        }

        return -1;

    }
}
