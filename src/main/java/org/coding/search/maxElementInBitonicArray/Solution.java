package org.coding.search.maxElementInBitonicArray;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int n = arr.length;

        if(n==1)
        {
            return 0;
        }

        //add code here.
        int start =0;
        int end = n-1;

        while(start<=end)
        {
            int mid = start+((end-start)/2);
            int previous = mid-1;
            int next = mid+1;

            if(previous >= 0 && next < n)
            {
                if(arr[mid] > arr[previous] && arr[mid] > arr[next])
                {
                    return mid;
                }

                else if(arr[mid] < arr[previous])
                {
                    end = mid-1;
                }

                else
                {
                    start = mid+1;
                }
            }

            else if (mid ==0)
            {
                if(arr[mid] > arr[next])
                {
                    return mid;
                }
                else {
                    return mid + 1;
                }
            }

            else if (mid == n-1)
            {
                if(arr[mid] > arr[previous])
                {
                    return mid;
                }
                else
                {
                    return mid-1;
                }
            }
        }

        return  -1;
    }
}