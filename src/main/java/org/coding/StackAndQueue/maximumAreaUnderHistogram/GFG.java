package org.coding.StackAndQueue.maximumAreaUnderHistogram;// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends





class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here

		int pseudoInteger = -1;
		Stack<Integer> stacknsl = new Stack<>();
		Stack<Integer> stacknsr = new Stack<>();
		long[] nsl = new long[(int) n];
		long[] nsr= new long[(int) n];

		long[] width = new long[(int)n];

		long maxArea = 0;


		for(int i =0; i <n; i++)
		{
			if(stacknsl.isEmpty())
			{
				nsl[i] =pseudoInteger;
			}

			else if(!stacknsl.isEmpty() && hist[i] > hist[Math.toIntExact(stacknsl.peek())])
			{
				nsl[i] = stacknsl.peek();
			}

			else if(!stacknsl.isEmpty() && hist[i] <= hist[Math.toIntExact(stacknsl.peek())])
			{
				while(!stacknsl.isEmpty() && hist[i] <= hist[Math.toIntExact(stacknsl.peek())])
				{
					stacknsl.pop();

				}
				if(stacknsl.isEmpty())
				{
					nsl[i] = pseudoInteger;
				}
				else
				{
					nsl[i] = stacknsl.peek();
				}
			}

			stacknsl.push(i);
		}


		pseudoInteger = (int) n;

		for(int i = (int) (n-1); i >=0; i--)
		{
			if(stacknsr.isEmpty())
			{
				nsr[i] =pseudoInteger;
			}

			else if(!stacknsr.isEmpty() && hist[i] > hist[Math.toIntExact(stacknsr.peek())])
			{
				nsr[i] = stacknsr.peek();
			}

			else if(!stacknsr.isEmpty() && hist[i] <= hist[Math.toIntExact(stacknsr.peek())])
			{
				while(!stacknsr.isEmpty() && hist[i] <= hist[Math.toIntExact(stacknsr.peek())])
				{
					stacknsr.pop();

				}
				if(stacknsr.isEmpty())
				{
					nsr[i]= pseudoInteger;
				}
				else
				{
					nsr[i]= stacknsr.peek();
				}
			}

			stacknsr.push(i);
		}
		for(int i =0; i < n; i ++)
		{
			width[i] =(nsr[i] - nsl[i] -1)* hist[i];
			if(width[i] > maxArea)
			{
				maxArea = width[i];
			}
		}

		return maxArea;
    }
        
}
