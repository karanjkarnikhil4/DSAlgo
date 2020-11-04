package org.coding.arrays;

//public class SingleNumber {
//}

// { Driver Code Starts
//Initial Template for Java

import java.util.Scanner;
class SingleNumber
{
    public static void main (String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

            System.out.println (new Sol().search (arr, n));
        }

    }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int A[], int N)
    {
        if(A.length == 1)
            return A[0];

        int number = A[0];

        for(int i =1; i< N ; i ++ )
        {
            number = number ^ A[i];
        }

        return number;
    }
}
