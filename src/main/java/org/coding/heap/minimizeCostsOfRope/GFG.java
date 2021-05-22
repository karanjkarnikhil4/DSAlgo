package org.coding.heap.minimizeCostsOfRope;// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        
        //Taking input using class Scanner
        Scanner in = new Scanner(System.in);
        
        //Taking count of testcases
        int t = in.nextInt();
        while (t-- > 0) {
            
            //takling count of elements
            int n = in.nextInt();
            
            //Creating an array of size n
            long arr[] = new long[n];

            //inserting elements to the array
            for (int i = 0; i < n; ++i) arr[i] = in.nextLong();

            //calling minCost method of class solve
            System.out.println(new Solution().minCost(arr, n));
        }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        long cost = 0;

        for(int i = 0; i <n; i++)
        {
            priorityQueue.add(arr[i]);
        }

        while(priorityQueue.size() >1)
        {

            long ropeSize = (priorityQueue.poll() + priorityQueue.poll());
            cost += ropeSize;
            priorityQueue.add(ropeSize);
        }

        return cost;
    }
}