package org.coding.StackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class NextLargerElement {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        Long t = Long.parseLong(read.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");

            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            getNextLargerElements(arr);
        }
    }

    private static void getNextLargerElements(int[] arr) {

        int[] newArray = new int[arr.length];

        for (int i =0; i<arr.length ; i++)
        {
            newArray[i]= -1;
        }

        if(arr==null || arr.length ==0)
        {
            printArray(newArray);
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int j=1; j< arr.length; j++)
        {
            while(!stack.isEmpty() && arr[j] > arr[stack.peek()])
            {
                newArray[stack.pop()] = arr[j];
            }

            stack.push(j);
        }

        printArray(newArray);



    }


    public  static void printArray(int[] arr)
    {
        for (int i =0; i < arr.length; i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}
