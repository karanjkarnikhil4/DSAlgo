package org.coding.arrays.findElementWithleftSideSmallerAndrightSideGreater;// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.findElement(a, n));
            
        }
	}
}// } Driver Code Ends


//User function Template for Java

class Compute {
    public int findElement(int arr[], int n){
        int[] rightArray = new int[n];
        int[] leftArray = new int[n];

        int min = Integer.MAX_VALUE;

        for(int i =n-2; i>=0 ;i--)
        {
            if(arr[i+1] < min)
            {
                rightArray[i]=arr[i+1];
                min=arr[i+1];
            }
            else
            {
                rightArray[i] = min;
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i =1; i <n; i++)
        {
            if(arr[i-1] > max)
            {
                leftArray[i] = arr[i-1];
                max=arr[i-1];
            }
            else
            {
                leftArray[i] = max;
            }
        }

        int number =-1;
        for(int i =1; i <= n-2;i++)
        {
            if(arr[i] >= leftArray[i] && arr[i] <= rightArray[i])
            {
                number = arr[i];
                break;
            }
        }

        return number;
    }
}