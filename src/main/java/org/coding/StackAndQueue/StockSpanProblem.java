package org.coding.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpanProblem {
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

            printSpanOfEveryElement(arr, sizeOfArray);
            System.out.println("");
        }
    }

    private static void printSpanOfEveryElement(int[] arr, int sizeOfArray) {

        if (arr == null)
            return;

        if (sizeOfArray == 1)
            System.out.println("1 ");

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < sizeOfArray; i++) {
            if (stack.empty()) {
                System.out.print(i - 0 + 1+" ");
                stack.push(i);
            } else if (arr[i] > arr[stack.peek()]) {
                while (!stack.empty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }

                if (stack.empty()) {
                    System.out.print(i - 0 + 1+" ");
                } else {
                    System.out.print(i - stack.peek()+" ");
                }

                stack.push(i);

            } else {
                stack.push(i);
                System.out.print("1"+" ");
            }
        }
    }
}
