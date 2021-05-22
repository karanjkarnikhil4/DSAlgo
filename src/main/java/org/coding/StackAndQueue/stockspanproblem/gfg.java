package org.coding.StackAndQueue.stockspanproblem;// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int a[] = new int[n];
            
            int i = 0;
            for(i = 0; i < n; i++)
              a[i] = sc.nextInt();
              
            int[] s = new Solution().calculateSpan(a, n);
            
            for(i = 0; i < n; i++)
            {
                System.out.print(s[i] + " ");
            }
            
            System.out.println();
        }
    }
    
    
    
}// } Driver Code Ends





class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        Stack<Integer> stack = new Stack<>();
        int[] spanArray = new int[n];

        for(int i = 0; i< n ;i++)
        {
            if(stack.isEmpty())
            {
                spanArray[i] =1;
            }
            else if(!stack.isEmpty() && price[i] < price[stack.peek()])
            {
                spanArray[i] = 1;
            }
            else if(!stack.isEmpty() && price[i]>= price[stack.peek()])
            {
                while(!stack.isEmpty() && price[i] >= price[stack.peek()])
                {
                    stack.pop();
                }

                if(stack.isEmpty())
                {
                    spanArray[i] = i+1;
                }
                else
                {
                    spanArray[i] = i-stack.peek();
                }
            }

            stack.push(i);
        }

        return spanArray;
    }
    
}