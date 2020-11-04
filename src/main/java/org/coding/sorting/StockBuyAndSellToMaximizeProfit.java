package org.coding.sorting;


/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class StockBuyAndSellToMaximizeProfit {
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

            printProfitDays(arr, n);

            System.out.println();
        }
    }

    private static void printProfitDays(int[] arr, int n) {

        if(arr ==null || arr.length ==1)
        {
            System.out.print("No Profit");
        }

        boolean isProfit = false;

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int firstIndex =  -1;

        for(int i =0; i < arr.length; i ++)
        {
            if(arr[i] < arr[stack.peek()])
            {

                while (!stack.isEmpty())
                {
                    firstIndex = stack.pop();
                }

                if((i-1)> firstIndex) {
                    System.out.print("(" + firstIndex + " " + (i - 1) + ")" + " ");
                    isProfit=true;
                }
                stack.push(i);
            }

            else
            {
                stack.push(i);
            }

        }

        if(!stack.isEmpty() && stack.size() > 1) {
            int lastIndex = stack.peek();
            while (!stack.isEmpty()) {
                firstIndex = stack.pop();
            }
            if(lastIndex > firstIndex) {
                System.out.print("(" + firstIndex + " " + lastIndex + ")" + " ");
                isProfit = true;
            }
        }

        if(!isProfit)
        {
            System.out.println("No Profit ");
        }

    }
}