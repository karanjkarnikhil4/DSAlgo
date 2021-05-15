package org.coding.graph.findIfPathExists;

// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while(T-->0)
    {
      int n = Integer.parseInt(br.readLine().trim());
      int[][] grid = new int[n][n];
      for(int i = 0; i < n; i++){
        String[] S = br.readLine().trim().split(" ");
        for(int j = 0; j < n; j++){
          grid[i][j] = Integer.parseInt(S[j]);
        }
      }
      Solution obj = new Solution();
      boolean ans = obj.is_Possible(grid);
      if(ans)
        System.out.println("1");
      else
        System.out.println("0");
    }
  }
}// } Driver Code Ends


class Solution
{

  boolean traversalPossible = false;

  class Cell
  {
    int row;
    int column;
    public Cell(int i, int j)
    {
      this.row = i;
      this.column = j;
    }
  }

  boolean isWithBoundary(int row,int column, int[][] grid)
  {
    if(row>=0 && row< grid.length && column>=0 && column < grid[0].length)
    {
      return true;
    }
    return false;
  }

  private void bfsCore(Cell cell,int[][] grid,boolean[][] visited)
  {
    Queue<Cell> queue = new LinkedList<>();
    queue.add(cell);
    visited[cell.row][cell.column] = true;

    int[] row =  {-1,0,0,1};
    int[] column={0,-1,1,0};

    while(!queue.isEmpty())
    {
      Cell poppedCell =queue.poll();
      if(grid[poppedCell.row][poppedCell.column] == 2)
      {
        traversalPossible = true;
      }
      for(int k = 0; k< 4 ;k++)
      {
        int neighBouringRow =poppedCell.row +row[k];
        int neighBouringColumn =poppedCell.column+column[k];
        if(isWithBoundary(neighBouringRow ,neighBouringColumn,grid) && isNotWall(neighBouringRow, neighBouringColumn,grid) && !visited[neighBouringRow][neighBouringColumn] )
        {
          visited[neighBouringRow][neighBouringColumn] = true;
          Cell neighBouringCell = new Cell(neighBouringRow,neighBouringColumn);
          queue.add(neighBouringCell);
        }

      }
    }

  }

  private boolean isNotWall(int neighBouringRow, int neighBouringColumn, int[][] grid) {

    return grid[neighBouringRow][neighBouringColumn] != 0;
  }

  public boolean is_Possible(int[][] grid)
  {
    int[] row =  {-1,0,0,1};
    int[] column={0,-1,1,0};


    int rowCount = grid.length;
    int columnCount = grid[0].length;
    boolean[][] visited = new boolean[rowCount][columnCount];

    for(int rowNo =0; rowNo< rowCount; rowNo ++)
    {
      for (int columnNo = 0; columnNo < columnCount; columnNo++) {

            if(grid[rowNo][columnNo] == 1)
            {
               bfsCore(new Cell(rowNo,columnNo),grid,visited);
            }
      }
      }

    return traversalPossible;
    // Code here
  }
}