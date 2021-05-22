package org.coding.kadanesalgorithm;// { Driver Code Starts
import java.io.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling maxSubarraySum() function
		    System.out.println(obj.maxSubarraySum(arr, n));
		}
	}
}

// } Driver Code Ends


class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int arr[], int n){
        
        // Your code here
		if(arr.length ==1)
			return arr[0];
		int front =1;
		int back =0;

		int sum = arr[0];
		int max = arr[0];

		while(back<=front && front <n)
		{
			if(sum+arr[front] < arr[front])
			{
				sum=arr[front];
				back =front;
			}
			else
			{
				sum+=arr[front];
			}

			if(sum>max)
			{
				max = sum;
			}
			front++;
		}
		return max;
        
    }
    
}