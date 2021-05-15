package org.coding.Bitmagic.FindFirstSetBit;// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class BitWise {


  // } Driver Code Ends


//User function Template for Java

  /*  Function to find position with first set bit
   *   n: input integer
   */
  public static int getFirstSetBit(int n){

    if (n==0)
    {
      return 0;
    }
    // Your code here
    int position =1;
    while(n>0)
    {
       if(n%2 ==1)
       {
         break;
       }
       n= n/2;
       position++;
    }
    return position;
  }

// { Driver Code Starts.

  public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();//taking testcases
    while(t-->0){
      int n=sc.nextInt();//input n
      System.out.println(getFirstSetBit(n));//calling method
    }
  }
}