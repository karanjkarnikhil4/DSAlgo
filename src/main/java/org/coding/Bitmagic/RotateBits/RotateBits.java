package org.coding.Bitmagic.RotateBits;

// { Driver Code Starts
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
      int d = sc.nextInt();

      Solution ob = new Solution();

      ArrayList<Integer> res = ob.rotate (n, d);
      System.out.println(res.get(0));
      System.out.println(res.get(1));


    }
  }
}// } Driver Code Ends


//User function Template for Java

class Solution
{

  ArrayList<Integer> rotate(int N, int D)
  {
    ArrayList<Integer> arrayList = new ArrayList<>();
    // your code here
    System.out.println("now N is "+Integer.toBinaryString(N));

    int left =N << D;
    System.out.println("Now left is "+Integer.toBinaryString(left));
    System.out.println("now N is "+Integer.toBinaryString(N));
    int right = N >>D;
    System.out.println("Now right is "+Integer.toBinaryString(right));
    arrayList.add(left);
    arrayList.add(right);
    return arrayList;
  }
}