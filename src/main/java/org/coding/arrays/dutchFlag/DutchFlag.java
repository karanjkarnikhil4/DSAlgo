package org.coding.arrays.dutchFlag;

// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

import static com.sun.tools.javac.jvm.ByteCodes.swap;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here
        int pointer =0;
        int pivot = 1;
        int start =-1;
        int end =n;
        while(pointer < end)
        {
            if(a[pointer] <pivot)
            {
                start++;
                swap(pointer,start,a);
                pointer++;
            }

            else if(a[pointer] > pivot)
            {
                end--;
                swap(pointer, end,a);
            }
            else
            {
                pointer ++;
            }
        }
    }

    private static void swap(int pointer , int pivot,int[] a)
    {

        int temp = a[pointer];
         a[pointer] = a[pivot];
         a[pivot]=temp;
    }

}

// { Driver Code Starts.

// } Driver Code Ends
class GFG {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}