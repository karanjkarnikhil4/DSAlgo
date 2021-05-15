package org.coding.graph.numberofIsands;

// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class GFG
{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while(T-->0)
    {
      String[] s = br.readLine().trim().split(" ");
      int n = Integer.parseInt(s[0]);
      int m = Integer.parseInt(s[1]);
      char[][] grid = new char[n][m];
      for(int i = 0; i < n; i++){
        String[] S = br.readLine().trim().split(" ");
        for(int j = 0; j < m; j++){
          grid[i][j] = S[j].charAt(0);
        }
      }
      Solution obj = new Solution();
      int ans = obj.numIslands(grid);
      System.out.println(ans);
    }
  }
}// } Driver Code Ends


class Solution
{

  boolean isWithBoundary(int row,int column, char[][] grid)
  {
     if(row>=0 && row< grid.length && column>=0 && column < grid[0].length)
     {
       return true;
     }
     return false;
  }

  private void bfsCore(Cell cell,char[][] grid,boolean[][] visited)
  {
          Queue<Cell> queue = new LinkedList<>();
          queue.add(cell);
          visited[cell.row][cell.column] = true;

          int[] row =  {-1,-1,-1,0,0,1,1,1};
          int[] column={-1,0,1,-1,1,-1,0,1};

          while(!queue.isEmpty())
          {
              Cell poppedCell =queue.poll();
              for(int k = 0; k< 8 ;k++)
              {
                int neighBouringRow =poppedCell.row +row[k];
                int neighBouringColumn =poppedCell.column+column[k];
                  if(isWithBoundary(neighBouringRow ,neighBouringColumn,grid) && isAnIsland(neighBouringRow, neighBouringColumn,grid) && !visited[neighBouringRow][neighBouringColumn] )
                  {
                      visited[neighBouringRow][neighBouringColumn] = true;
                      Cell neighBouringCell = new Cell(neighBouringRow,neighBouringColumn);
                      queue.add(neighBouringCell);
                  }

              }
          }

  }

  private boolean isAnIsland(int i, int i2, char[][] grid) {
    return (grid[i][i2]) == '1';
  }

  public int numIslands(char[][] grid)
  {
     int rowCount = grid.length;
     int columnCount = grid[0].length;
     boolean[][] visitedArray = new boolean[rowCount][columnCount];
     int countOfIslands = 0;
     for(int row =0; row< rowCount; row ++)
     {
       for(int column=0; column < columnCount; column++)
       {
            if(!visitedArray[row][column] && isAnIsland(row, column, grid))
            {
              bfsCore(new Cell(row,column),grid,visitedArray);
              countOfIslands++;
            }
       }
     }
    return countOfIslands;
  }

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
}