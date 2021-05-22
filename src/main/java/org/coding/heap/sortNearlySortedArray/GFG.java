package org.coding.heap.sortNearlySortedArray;/*package whatever //do not write package name here */


import java.lang.*;
import java.io.*;
import java.util.PriorityQueue;

public class GFG {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader read =
				new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t-- > 0) {
			String S[] = read.readLine().split(" ");

			int n = Integer.parseInt(S[0]);
			int k = Integer.parseInt(S[1]);

			String S1[] = read.readLine().split(" ");

			int[] arr = new int[n];

			for(int i=0; i<n; i++)
				arr[i] = Integer.parseInt(S1[i]);

			Solution ob = new Solution();
			int[] ptr = ob.sort(k,arr,n);
			for(int i=0; i<n; i++)
				System.out.print(ptr[i] + " ");
			System.out.println();
		}
	}
}

 class Solution {
	 public int[] sort(int k, int[] arr, int n) {
	 	int[] resultArray = new int[n];
	 	int resultArrayPointer = 0;
		 PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int min = Math.min(k,n-1);
	 	for(int i =0; i <=min ; i ++)
		{
			priorityQueue.add(arr[i]);
		}

	 	for(int i = k+1; i < n ; i++)
		{
			resultArray[resultArrayPointer++]=priorityQueue.poll();
			priorityQueue.add(arr[i]);
		}

	 	while(priorityQueue.size() >0)
		{
			resultArray[resultArrayPointer++] = priorityQueue.poll();
		}

	 	return resultArray;
	 }
 }
