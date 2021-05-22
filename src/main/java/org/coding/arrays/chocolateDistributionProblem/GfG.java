package org.coding.arrays.chocolateDistributionProblem;// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            ArrayList<Long> arr = new ArrayList<Long>();
            for(int i = 0;i<n;i++)
                {
                    long x = sc.nextInt();
                    arr.add(x);
                }
            long m = sc.nextLong();
            
            Solution ob = new Solution();
            
    		System.out.println(ob.findMinDiff(arr,n,m));
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        a.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                if(o1 >o2) return 1;
                else if(o1 ==o2)return 0;
                else return -1;
            }
        });
        long pointer1 =m-1;
        long pointer2 =0;

        long min = Long.MAX_VALUE;

        while(pointer1 < n)
        {
            long difference = a.get((int) pointer1) - a.get((int) pointer2);
            if(difference < min)
            {
                min =difference;
            }
            pointer1++;
            pointer2++;
        }
    return min;
    }
}