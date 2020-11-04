package org.coding.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsingStacks {
    public static void main(String[] args) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                if (!stack2.isEmpty()) {
                    pushFromStackToStack(stack2, stack1);
                }
                stack1.push(scan.nextInt());
            } else if (operation == 2) { // dequeue

                if (stack2.isEmpty()) {
                    pushFromStackToStack(stack1, stack2);
                }
                stack2.pop();

            } else if (operation == 3) { // print/peek
                if (stack2.isEmpty()) {
                    pushFromStackToStack(stack1, stack2);
                }
                System.out.println(stack2.peek());
            }
        }
        scan.close();
    }


    private static void pushFromStackToStack(Stack<Integer> stack1, Stack<Integer> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }


}