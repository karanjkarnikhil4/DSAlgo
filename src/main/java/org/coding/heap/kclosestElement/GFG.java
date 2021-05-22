package org.coding.heap.kclosestElement;// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);


            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {

        // code here
        int low =0;
        int high = n-1;
        int[] result = new int[k];
        while(low<=high)
        {
            int mid = low + ((high-low)/2);
            if(arr[mid] ==x)
            {
                high = mid-1;
                low = mid+1;
                break;
            }
            else if( arr[mid] > x )
            {
                high = mid-1;
            }

            else
            {
                low = mid+1;
            }
        }
        int temp = low;
        low = high;
        high = temp;

        for(int i =0; i < k; i++)
        {
            int highDiff =0;
            int lowDiff =0;
            if(high<n) {
            highDiff=Math.abs(arr[high] - x);
            }
            if(low >=0)
            {
                lowDiff = Math.abs(arr[low] -x);
            }
            if(high <n && low >=0) {
                if (highDiff > lowDiff) {
                    result[i]=arr[low];
                    low--;
                } else if (highDiff < lowDiff) {
                    result[i]=arr[high];
                    high++;
                } else {
                    result[i]=arr[high];
                    high++;
                }
            }
            else if(high==n && low >=0)
            {
                result[i]=arr[low];
                low--;
            }

            else if(low<0 && high <n)
            {
                result[i]=arr[high];
                high++;
            }

        }
        return result;
    }
}