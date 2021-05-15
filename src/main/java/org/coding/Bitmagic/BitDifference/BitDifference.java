package org.coding.Bitmagic.BitDifference;

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends


//User function Template for Java

class CountBitFlip{

  // Function to find number of bits needed to be flipped to convert A to B
  public static int countBitsFlip(int a, int b){

    // Your code here

    int XOR = a^ b;
    int count =0;
    while(XOR >0)
    {
      if(XOR %2 ==1)
      {
        count++;
      }
      XOR = XOR/2;
    }

    return count;
  }


}


// { Driver Code Starts.

// Driver class
class BitWise {

  public static void main(String[] args) throws NumberFormatException, IOException {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();//testcases
    int m, n;
    long ans = 0; // initialise ans to 0
    while(t-->0) {

      //input m and n
      m = sc.nextInt();
      n = sc.nextInt();
      CountBitFlip obj = new CountBitFlip();
      System.out.println(obj.countBitsFlip(m, n));
    }
  }
}
