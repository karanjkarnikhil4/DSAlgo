package org.coding.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {

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

            boolean containsDuplicates = containsDuplicates(arr, n);

            if(containsDuplicates)
            System.out.println("True");
            else
                System.out.println("False");
        }
    }

    private static boolean containsDuplicates(int[] arr, int n) {

        Set<Integer> set = new HashSet<>();
        boolean containsDuplicates = false;

        for (int i = 0; i < arr.length; i++) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
            } else {
                containsDuplicates = true;
                break;

            }
        }

        return containsDuplicates;
    }
}
