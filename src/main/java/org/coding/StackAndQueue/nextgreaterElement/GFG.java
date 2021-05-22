package org.coding.StackAndQueue.nextgreaterElement;// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        // Your code here
		Stack<Long> stack = new Stack<>();
		long[] resultArray = new long[n];
		for(int i =n-1,j=0;i>=0 && j<n; i--,j++)
		{
			if(stack.isEmpty())
			{
				resultArray[j] =-1;
			}

			else if(!stack.isEmpty() && arr[i] >= stack.peek())
			{
				while(!stack.isEmpty() &&stack.peek() <= arr[i])
				{
					stack.pop();
				}

				if(stack.isEmpty())
				{
					resultArray[j] = -1;
				}
				else
				{
					resultArray[j] = stack.peek();
				}
			}
			else if(!stack.isEmpty() && arr[i] < stack.peek())
			{
				resultArray[j] = stack.peek();
			}
			stack.push(arr[i]);
		}

		return reverseArray(resultArray,n);
    }

    private static long[] reverseArray(long[] arr,int n)
	{
		for(int i =0,j=n-1;i<j;i++,j--)
		{
			swap(i,j,arr);
		}
		return arr;
	}

	private static void swap(int i, int j, long[] arr)
	{
		long temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}