//package org.coding.arrays;
//
////public class FindDuplicatesInAnArray {
////}
//
//// { Driver Code Starts
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Set;
//
//class FindDuplicatesInAnArray {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while (t-- > 0) {
//            int n = sc.nextInt();
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
//            Solution4 g = new Solution4();
//            ArrayList<Integer> ans = g.duplicates(a, n);
//            for (Integer val : ans) System.out.print(val + " ");
//
//        }
//    }
//}
//// } Driver Code Ends
//
//
//class Solution4 {
//    public static ArrayList<Integer> duplicates(int arr[], int n) {
//        // code here
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        int[] resultarr = new int[n];
//
//        for(int j =0; j< n; j++)
//        {
//            resultarr[j] = -1;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (arr[Math.abs(arr[i])] >= 0) {
//                arr[Math.abs(arr[i])] = arr[Math.abs(arr[i])] * -1;
//            } else {
//                if( resultarr[Math.abs(arr[i])] == -1)
//                {
//                    resultarr[Math.abs(arr[i])] =1;
//                }
//                else
//                {
//                    resultarr[Math.abs(arr[i])] = resultarr[Math.abs(arr[i])] +1;
//                }
//            }
//        }
//
//        if(linkedHashSet.size() ==0)
//            list.add(-1);
//
//        else
//        {
//            for (Integer j:
//            linkedHashSet) {
//                list.add(j);
//            }
//        }
//        return list.sort((o1, o2) -> {o1<o2? return 1: return -1));
//    }
//}
