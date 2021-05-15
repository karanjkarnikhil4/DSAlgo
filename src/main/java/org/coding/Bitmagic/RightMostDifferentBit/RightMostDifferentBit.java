package org.coding.Bitmagic.RightMostDifferentBit;

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Bitwise{


  // } Driver Code Ends


//User function Template for Java


  /*  function to find position of rightmost different bit
   *   m, n : Integers to find rightmost different bits
   *   You can have a look in the locked code for information
   *   regarding other functions including driver code
   */
  public static int posOfRightMostDiffBit(int m, int n) {

    // Your code here

    int xoredVersion = m ^n;

    return getFirstSetBit(xoredVersion);

  }

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

  public static void main(String[] args) throws NumberFormatException, IOException {
    Scanner sc=new Scanner(System.in);

    //input number of testcases
    int t=sc.nextInt();
    int m,n;
    while(t-->0) {



      //input m and n
      m = sc.nextInt();
      n = sc.nextInt();
      System.out.println(posOfRightMostDiffBit(m, n));
    }
  }
}
