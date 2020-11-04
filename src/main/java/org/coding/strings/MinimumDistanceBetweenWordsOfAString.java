//package org.coding.strings;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class MinimumDistanceBetweenWordsOfAString {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int tc = Integer.parseInt(br.readLine());
//        while (tc-- > 0) {
//            int n = Integer.parseInt(br.readLine());
//            int[] arr = new int[n];
//            String[] inputLine = br.readLine().split(" ");
//            for (int i = 0; i < n; i++) {
//                arr[i] = Integer.parseInt(inputLine[i]);
//            }
//
//            int majorityElement = getMinimumDistanceBetweenWords(arr, n);
//
//            System.out.println(majorityElement);
//        }
//    }
//
//    private static int getMinimumDistanceBetweenWords(String[] arr, String word1, String word2) {
//    }
//}
