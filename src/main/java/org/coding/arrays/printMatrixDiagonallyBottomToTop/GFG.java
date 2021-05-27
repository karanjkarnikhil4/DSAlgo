package org.coding.arrays.printMatrixDiagonallyBottomToTop;// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.downwardDigonal(n, matrix);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<Integer> downwardDigonal(int n, int A[][])
    {
        // code here
        int rows = n;
        int columns =n;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int row =0; row < n; row++)
        {
            int currColumn =0;
            int currRow =row;
            while(currRow >= 0 && currColumn <n)
            {
                arrayList.add(A[currRow--][currColumn++]);
            }
        }

        for(int column =1; column < n; column++)
        {
            int currColumn =column;
            int currRow =n-1;
            while(currRow >= 0 && currColumn <n)
            {
                arrayList.add(A[currRow--][currColumn++]);
            }
        }

        return arrayList;

    }
}
