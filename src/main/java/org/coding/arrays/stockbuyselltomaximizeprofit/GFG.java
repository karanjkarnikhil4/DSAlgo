package org.coding.arrays.stockbuyselltomaximizeprofit;// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int A[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                A[i] = Integer.parseInt(inputLine[i]);
            }
            int p = 0;
            for(int i=0; i<n-1; i++)
                p += Math.max(0,A[i+1]-A[i]);
                
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer> > ans = obj.stockBuySell(A, n);
            if(ans.size()==0)
                System.out.print("No Profit");
            else{
                int c=0;
                for(int i=0; i<ans.size(); i++)
                    c += A[ans.get(i).get(1)]-A[ans.get(i).get(0)];
                
                if(c==p)
                    System.out.print(1);
                else
                    System.out.print(0);
            }System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> arrayListArrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
       // int profit = 0;
        for(int i =0; i<n ; i++)
        {
            if(stack.isEmpty() || A[stack.peek()] <= A[i])
            {
                stack.push(i);
            }
            else{
                int investingDay = -1;
                while(!stack.isEmpty())
                {
                    investingDay = stack.pop();
                }

                ArrayList<Integer> arrayList = new ArrayList<>();
                if(investingDay != i-1) {
                    arrayList.add(investingDay);
                    arrayList.add(i - 1);
                    arrayListArrayList.add(arrayList);
                }
                stack.push(i);
            }
        }
        if(!stack.isEmpty()) {
            int investingDay = -1;
            while (!stack.isEmpty()) {
                investingDay = stack.pop();
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            if(investingDay != n-1) {
                arrayList.add(investingDay);
                arrayList.add(n - 1);
                arrayListArrayList.add(arrayList);
            }
        }
        return arrayListArrayList;
    }
}