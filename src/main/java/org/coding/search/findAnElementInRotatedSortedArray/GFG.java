package org.coding.search.findAnElementInRotatedSortedArray;// { Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int A[] = new int[n];

            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            int key = sc.nextInt();

            System.out.println(new Solution().search(A, 0, n - 1, key));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int search(int A[], int l, int h, int key) {

        int start = l;
        int end = h;
        int n = h + 1;

        int firstElementIndex = -1;


        while (start <= end) {
            if (A[start] <= A[end]) {
                firstElementIndex = start;
                break;
            }

            int mid = start + ((end - start) / 2);
            int previous = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (A[mid] <= A[previous] && A[mid] <= A[next]) {
                firstElementIndex = mid;
                break;
            }

            if (A[start] <= A[mid]) {
                start = mid + 1;
            } else if (A[mid] <= A[end]) {
                end = mid - 1;
            }
        }


        if (firstElementIndex == 0) {
            if (A[firstElementIndex] == key) {
                return firstElementIndex;
            } else {
                start = firstElementIndex + 1;
                end = n - 1;
                Integer mid1 = BinarySearch(A, key, start, end);
                if (mid1 != null) return mid1;
            }
        } else if (firstElementIndex == n - 1) {
            if (A[firstElementIndex] == key) {
                return firstElementIndex;
            } else {
                start = 0;
                end = firstElementIndex - 1;
                Integer mid1 = BinarySearch(A, key, start, end);
                if (mid1 != null) return mid1;
            }
        } else {
            start = 0;
            end = firstElementIndex-1;
            Integer mid1 = BinarySearch(A, key, start, end);
            if (mid1 != null) return mid1;

            start = firstElementIndex+1;
            end = n-1;
            Integer mid2 = BinarySearch(A, key, start, end);
            if (mid2 != null) return mid2;

        }

        return -1;
    }

    private Integer BinarySearch(int[] A, int key, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);

            if (A[mid] == key) {
                return mid;
            } else if (A[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return null;
    }
}


//    int start = l;
//    int end = h;
//    int n = h + 1;
//
//    int firstElementIndex = -1;
//
//
//        while(start<=end)
//                {
//                if(A[start]<=A[end])
//                {
//                firstElementIndex=start;
//                break;
//                }
//
//                int mid=start+((end-start)/2);
//                int previous=(mid-1+n)%n;
//                int next=(mid+1)%n;
//
//                if(A[mid]<=A[previous]&&A[mid]<=A[next])
//                {
//                firstElementIndex=mid;
//                break;
//                }
//
//                if(A[start]<=A[mid])
//                {
//                start=mid+1;
//                }
//                else if(A[mid]<=A[end])
//                {
//                end=mid-1;
//                }
//                }