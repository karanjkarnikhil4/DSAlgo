package org.coding.search.peakElement;// { Driver Code Starts
import java.util.*;
class PeakElement{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
		    int[] tmp=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
				tmp[i] = a[i];
			}

		    int f=0;
			int A=(new Solution()).peakElement(tmp,n);

			if(A<0 && A>=n)
			    System.out.println(0);
			else
			{
    			if(n==1 && A==0)
    			    f=1;
    			else if(A==0 && a[0]>=a[1])
    			    f=1;
    			else if(A==n-1 && a[n-1]>=a[n-2])
    			    f=1;
    			else if(A >= 0 && A < n && a[A] >=a[A+1] && a[A]>= a[A-1])
    			    f=1;
    			else
    			    f=0;
			    System.out.println(f);
			}
		}
	}
}// } Driver Code Ends


/*Complete the function below*/

class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
    	if(n==1)
		{
			return 0;
		}

       //add code here.
		int start =0;
		int end = n-1;

		while(start<=end)
		{
			int mid = start+((end-start)/2);
			int previous = mid-1;
			int next = mid+1;

			if(previous >= 0 && next < n)
			{
				if(arr[mid] >= arr[previous] && arr[mid] >= arr[next])
				{
					return mid;
				}

				else if(arr[mid] < arr[previous])
				{
					end = mid-1;
				}

				else
				{
					start = mid+1;
				}
			}

			else if (mid ==0)
			{
				if(arr[mid] >= arr[next])
				{
					return mid;
				}
				else {
					return mid + 1;
				}
			}

			else if (mid == n-1)
			{
				if(arr[mid] >= arr[previous])
				{
					return mid;
				}
				else
				{
					return mid-1;
				}
			}
		}

		return  -1;
    }
}