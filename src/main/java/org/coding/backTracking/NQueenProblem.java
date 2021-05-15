package org.coding.backTracking;

// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
  public static void main(String args[])throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(in.readLine());
    while(t-- > 0) {
      int n = Integer.parseInt(in.readLine());

      Solution ob = new Solution();
      ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
      if(ans.size() == 0)
        System.out.println("-1");
      else {
        for(int i = 0;i < ans.size();i++){
          System.out.print("[");
          for(int j = 0;j < ans.get(i).size();j++)
            System.out.print(ans.get(i).get(j) + " ");
          System.out.print("] ");
        }
        System.out.println();
      }
    }
  }
}// } Driver Code Ends


// User function Template for Java

class Solution{

  private static ArrayList<ArrayList<Integer>> integerArrayList;
  static ArrayList<ArrayList<Integer>> nQueen(int n) {
    // code here
    integerArrayList = new ArrayList<>();
    if(n==1)
    {
      ArrayList<Integer> arrayList  = new ArrayList<>();
      arrayList.add(1);
      integerArrayList.add(arrayList);
      return integerArrayList;
    }
    int[][] queenBoard = new int[n][n];
    for(int[] row: queenBoard)
    {
      Arrays.fill(row,-1);
    }
    ArrayList<Integer> arrayList = new ArrayList<>();
    buildNQueenBoard(arrayList,0,queenBoard);
    return integerArrayList;

  }


  private static void buildNQueenBoard(ArrayList<Integer> arrayList,int column,int[][] queenBoard)
  {

    if(column >=queenBoard.length)
    {

      integerArrayList.add(new ArrayList<>(arrayList));
      return;
    }

      for(int i =0; i < queenBoard.length; i ++)
      {
          if(isSafe(i,column,queenBoard))
          {
            queenBoard[i][column] =1;
            arrayList.add(i+1);
            buildNQueenBoard(arrayList,column+1,queenBoard);
            queenBoard[i][column] =0;
            arrayList.remove(arrayList.size()-1);

          }
      }
  }

  private static boolean isSafe(int row, int column, int[][] queenBoard)
  {
       for(int j = column; j>=0; j-- )
       {
         if(queenBoard[row][j]==1)
         {
           return false;
         }
       }

     for(int j =column,i = row; j>=0 && i>=0; j--,i--)
     {
       if(queenBoard[i][j]==1)
       {
         return false;
       }
     }

    for(int j =column,i = row; i<queenBoard.length && j>=0; j--,i++)
    {
      if(queenBoard[i][j]==1)
      {
        return false;
      }
    }

    return true;
  }
}
