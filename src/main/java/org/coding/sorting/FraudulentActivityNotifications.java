package org.coding.sorting;

import java.io.IOException;
import java.util.Scanner;

public class FraudulentActivityNotifications {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        if (expenditure.length <= d) {
            return 0;
        }

        int i = d - 1, j = 0, count = 0;


        while (i <= expenditure.length - 2) {

                int[] dArray = new int[d];
                int dArrayIndex = 0;
                for (int k = j; k <= i; k++) {
                    dArray[dArrayIndex] = expenditure[k];
                    dArrayIndex++;
                }

                double median = getMedian(dArray);

                if (( expenditure[i + 1]) >= (2 *median)) {
                    count++;

                }
                 i++;
                 j++;
        }


        return count;


    }

    private static double getMedian(int[] dArray) {


        if (dArray.length == 1) {
            return dArray[0];
        }

        for (int i = dArray.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (dArray[j] > dArray[j + 1]) {
                    swap(dArray, j, j + 1);
                }
            }
        }

        if (dArray.length % 2 != 0) {


            int middleElementIndex = ((dArray.length - 1) / 2);
            return dArray[middleElementIndex];
        } else {
            int middleElementIndex1 = ((dArray.length - 1) / 2);

            return (new Double(dArray[middleElementIndex1]) + new Double(dArray[middleElementIndex1 + 1]) / new Double(2));
        }

    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int tempVariable = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tempVariable;
    }

    public static void main(String[] args) throws IOException {


        int result = activityNotifications(new int[]{2,3,4,2,3,6,8,4,5}, 5);
        System.out.println(result);


    }
}
