package org.coding.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseAString {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String n = read.readLine();
            String reversedString =reverseString(n);
            System.out.println(reversedString);

        }

    }

    public static String reverseString(String inputString) {
        String[] splittedString = inputString.split("\\.");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(splittedString[splittedString.length-1]);

        for (int i = splittedString.length - 2; i >= 0; i--) {
            stringBuilder.append("."+splittedString[i]);
        }

        return stringBuilder.toString();
    }
}