package org.coding.arrays;// { Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsWithGivenSum {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new org.coding.arrays.Solution1234().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

  class Solution1234 {
    int getPairsCount(int[] arr, int n, int k) {
       Map<Integer, List<Integer>> map = new HashMap();
       int numberOfPairs = 0;

       for(int i =0; i< arr.length; i++)
       {
           int requiredValue =  k -arr[i];
           if(map.containsKey(requiredValue)) {
               for (Integer integer : map.get(requiredValue)) {
                   numberOfPairs++;
               }

           }

           if(map.containsKey(arr[i]))
           {
               List<Integer> values =map.get(arr[i]);
               values.add(i);
               map.put(arr[i],values);
           }

           else
           {

               List<Integer> arrayList = new ArrayList<>();
               arrayList.add(i);
               map.put(arr[i],arrayList);
           }

       }
        return numberOfPairs;

    }
}
