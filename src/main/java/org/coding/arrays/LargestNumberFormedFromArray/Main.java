package org.coding.arrays.LargestNumberFormedFromArray;// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            String[] arr = br.readLine().trim().split(" ");

            String ans = new Solution().printLargest(arr);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java



class Solution {
    String printLargest(String[] arr) {
        // code here

       Arrays.sort(arr,new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
              String XY = o1+o2;
              String YX = o2+o1;
              return XY.compareTo(YX) > 0 ? -1: 1;
           }
       });

      return String.join("",arr);

    }
}