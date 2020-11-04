package org.coding.StackAndQueue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Bracket {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        boolean isBalanced = true;
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {

            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            }



            else if (c == '}' ) {
                if (stack.empty() || stack.pop() != '{' ) {
                    isBalanced = false;
                    break;
                }
            }

            else if (c == ']') {
                if (stack.empty() || stack.pop() != '[') {
                    isBalanced = false;
                    break;
                }
            }

            else if (c == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    isBalanced = false;
                    break;
                }
            }

        }

        if(stack.size() >0)
        {
            isBalanced = false;
        }

        if (isBalanced) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int t = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int tItr = 0; tItr < t; tItr++) {
//            String s = scanner.nextLine();

            String result = isBalanced(new String("{[()]}"));

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
//        }
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
