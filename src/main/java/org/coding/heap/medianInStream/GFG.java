package org.coding.heap.medianInStream;// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}

// } Driver Code Ends



class Solution
{

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    //Function to insert heap.
    public static void insertHeap(int x)
    {
        if(maxHeap.isEmpty())
        {
            maxHeap.add(x);
        }
        else if( x <= maxHeap.peek())
        {
            maxHeap.add(x);
        }
        else if(x > maxHeap.peek())
        {
            minHeap.add(x);
        }

       if(Math.abs(minHeap.size() - maxHeap.size())>1)
       {
           balanceHeaps();
       }

        // add your code here
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
        if(maxHeap.size() - minHeap.size() > 1)
        {
            int value =maxHeap.poll();
            minHeap.add(value);
        }

        else if(minHeap.size() - maxHeap.size() > 1)
        {
            int value =minHeap.poll();
            maxHeap.add(value);
        }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(minHeap.size() == maxHeap.size())
        {
            return ((minHeap.peek() + maxHeap.peek())/2);
        }

        else if(minHeap.size() > maxHeap.size())
        {
            return  minHeap.peek();
        }

        else
        {
            return  maxHeap.peek();
        }
    }
    
}