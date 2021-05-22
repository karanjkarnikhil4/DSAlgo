package org.coding.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AreaUnderHistogram {

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

            int maxArea = maxAreaUnderHistogram(arr, sizeOfArray);
            System.out.println(maxArea);
        }
    }

    private static int maxAreaUnderHistogram(int[] arr, int sizeOfArray) {
        int maxArea = 0;
        int area;
        if (arr == null)
            return 0;

        if (sizeOfArray == 1)
            return arr[0];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sizeOfArray; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (arr[i] > arr[stack.peek()]) {
                stack.push(i);
            } else {

                while (!stack.empty() && arr[stack.peek()] > arr[i]) {
                    int index = stack.pop();
                     area = arr[index] * (i - stack.peek()-1);

                    if (area > maxArea) {
                        maxArea = area;
                    }
                }


                stack.push(i);
            }
        }

        while (!stack.empty() ) {
            int index = stack.pop();
            area = arr[index] * (sizeOfArray - stack.peek()-1);

            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
