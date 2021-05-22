package org.coding.arrays.kthsmallestElement;

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
        //Your code here
		if(l==r)
		{
			return arr[l];
		}
		int partitionIndex = partition(arr, l, r);
		if(partitionIndex ==(k-1))
		{
			return arr[partitionIndex];
		}
		else if(partitionIndex> (k-1))
		{
			return kthSmallest(arr,l,partitionIndex-1,k);
		}
		else
		{
			return kthSmallest(arr, partitionIndex+1, r, k);
		}
    }


    static int partition(int[] arr, int l , int r)
	{
		int pivot = arr[r] ;
		int start =l-1;
		for(int i =l;i<r; i++)
		{
			if(arr[i] < pivot)
			{
				start++;
				swap(arr,i,start);
			}
		}
		start++;
		swap(arr,r, start);
		return start;
	}

	static void swap(int[] arr, int index1, int index2)
	{

		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2]=temp;
	}


}
