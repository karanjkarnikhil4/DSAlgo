package org.coding.heap.kthsmallestElementMaxHeap;

//whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    {
    	PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
			if(o1 > o2) return -1;
			else if(o1==o2) return 0;
			else return  1;
		});

		for(int i =0; i < k ; i++)
		{
			priorityQueue.add(arr[i]);
		}

		for(int i = k;i<arr.length; i++)
		{
			if(arr[i] < priorityQueue.peek())
			{
				priorityQueue.poll();
				priorityQueue.add(arr[i]);
			}
		}
		return priorityQueue.peek();
    }
}
