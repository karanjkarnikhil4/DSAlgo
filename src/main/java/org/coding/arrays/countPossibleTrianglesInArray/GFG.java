package org.coding.arrays.countPossibleTrianglesInArray;// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        while(t > 0)
        {
            //taking elements count
            int n = sc.nextInt();
            
            //creating an array of length n
            int arr[] = new int[n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            
            //creating an object of class Solutions
            Solution ob = new Solution();
            
            //calling the method findNumberOfTriangles()
            //of class Solutions and printing the results
            System.out.println(ob.findNumberOfTriangles(arr,n));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        // code here
        int count =0;
        int k =-1;
        for(int i = 0; i<= n-3; i++)
        {
            for(int j=i+1;j <=n-2;j++)
            {
               k =j+1;
                while (k<n && (arr[i] + arr[j] > arr[k]))
                {
                    k++;
                }
             count+= k-1-j;

            }
        }
        return count;
    }
}