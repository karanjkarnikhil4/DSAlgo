package org.coding.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class AreaUnderHistogramGFG {

    public static void main(String[] args) throws IOException {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int sizeOfArray = Integer.parseInt(br.readLine());
            long[] arr = new long[sizeOfArray];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            long maxArea = getMaxArea(arr, sizeOfArray);
            System.out.println(maxArea);
        }
    }

    public static long getMaxArea(long hist[], long n)  {
        // your code here

        long maxArea = 0;
        long area;
        if (hist == null)
            return 0;

        if (n == 1)
            return hist[0];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (hist[i] > hist[stack.peek()]) {
                stack.push(i);
            } else {

                while (!stack.empty() && hist[stack.peek()] >= hist[i]) {
                    int index = stack.pop();
                    area = hist[index] * (i - index);

                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
                if(stack.empty())
                {
                    area = (i+1)*hist[i];
                }

                else
                {
                    area = (i-stack.peek())*hist[i];
                }

                if(area > maxArea)
                {
                    maxArea = area;
                }

                stack.push(i);
            }
        }

        while (!stack.empty()) {
            int index = stack.pop();
            area = hist[index] * (n-index);

            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}
