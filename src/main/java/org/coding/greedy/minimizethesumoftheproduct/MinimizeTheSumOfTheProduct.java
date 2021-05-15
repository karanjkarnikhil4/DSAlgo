package org.coding.greedy.minimizethesumoftheproduct;

// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine().trim());
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      long a[] = new long[(int) (n)];
      long b[] = new long[(int) (n)];

      String inputLine[] = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        a[i] = Long.parseLong(inputLine[i]);
      }
      String inputLine1[] = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        b[i] = Long.parseLong(inputLine1[i]);
      }

      Compute obj = new Compute();
      System.out.println(obj.minValue(a, b, n));
    }
  }
}
// } Driver Code Ends

// User function Template for Java

class Compute {

  public long minValue(long a[], long b[], long n) {
    // Your code goes here

    Arrays.sort(a);
    Arrays.sort(b);

    long minCost =0;

    for(long i =0, j=n-1;i<n;i++,j--)
    {
        minCost+=(a[(int) i]*b[(int) j]);
    }
    return minCost;
  }
}
