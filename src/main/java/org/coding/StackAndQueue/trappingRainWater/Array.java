package org.coding.StackAndQueue.trappingRainWater;// { Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}

// } Driver Code Ends




class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) { 
        
        // Your code here

		int sum =0;
		int[] LG = new int[n];
		int[] RG = new int[n];
		LG[0] = arr[0];
		RG[n-1] = arr[n-1];

		for(int i =1; i<n ; i++)
		{
			if(arr[i]> LG[i-1])
			{
				LG[i] = arr[i];
			}
			else
			{
				LG[i] = LG[i-1];
			}
		}

		for(int i =n-2; i>=0 ; i--)
		{
			if(arr[i]> RG[i+1])
			{
				RG[i] = arr[i];
			}
			else
   				RG[i] = RG[i+1];
			}

		for(int i =0; i< n; i++)
		{
			int min = Math.min(RG[i],LG[i]);
									sum+=min-arr[i];

		}
        return sum;
    } 
}