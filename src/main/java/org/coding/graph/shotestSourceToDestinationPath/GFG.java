package org.coding.graph.shotestSourceToDestinationPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class GFG {

  static class Cell
  {
    int row;
    int column;
    public Cell(int row, int column) {
      this.row = row;
      this.column = column;
    }
  }

  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while(T-->0)
    {
      String[] sizeOfMatrix = br.readLine().trim().split(" ");

      int rows = Integer.parseInt(sizeOfMatrix[0]);
      int columns = Integer.parseInt(sizeOfMatrix[1]);

      int[][] grid = new int[rows][columns];
       String[] input =br.readLine().trim().split(" ");
       int start = 0;
      for(int i = 0; i < rows; i++){

        for(int j =0; j< columns; j++)
        {
            grid[i][j] = Integer.parseInt(input[start]);
            start++;
        }
      }
      String[] inputSrcDest =br.readLine().split(" ");
      int destinationX = Integer.parseInt(inputSrcDest[0]);
      int destinationY = Integer.parseInt(inputSrcDest[1]);
      Cell destinationCell = new Cell(destinationX,destinationY);
      GFG shortestSourceToDestination = new GFG();
      int[][] distanceGrid = new int[rows][columns];
      setInitialDistanceToMinusOne(rows, columns, distanceGrid);
      boolean[][] visitedGrid = new boolean[rows][columns];
      shortestSourceToDestination.getShortestPath(grid,visitedGrid,distanceGrid,destinationCell);
      System.out.println(distanceGrid[destinationX][destinationY]);
     
    }
  }

  private static void setInitialDistanceToMinusOne(int rows, int columns, int[][] distanceGrid) {
    for(int i =0; i< rows; i++)
    {
      for(int j=0;j< columns; j++)
      {
        distanceGrid[i][j] = -1;
      }
    }
  }

  private void getShortestPath(int[][] grid, boolean[][] visitedGrid,int[][] distanceGrid,Cell destinationCell) {

    int[] searchRows = new int[]{-1,0,0,1};
    int[] searchColumns = new int[]{0,-1,1,0};
    Queue<Cell> queue = new LinkedList<>();

    visitedGrid[0][0] = true;
    distanceGrid[0][0] = 0;

    queue.add(new Cell(0,0));
    while(!queue.isEmpty())
    {
      Cell polledCell =  queue.poll();

      for(int k =0; k< 4; k++)
      {
          int neighBouringRow = polledCell.row + searchRows[k];
          int neighBouringColumn = polledCell.column + searchColumns[k];

          if(isValidNeighBour(neighBouringRow,neighBouringColumn,grid)&& !visitedGrid[neighBouringRow][neighBouringColumn])
          {
            distanceGrid[neighBouringRow][neighBouringColumn] = distanceGrid[polledCell.row][polledCell.column] + 1;
            visitedGrid[neighBouringRow][neighBouringColumn] = true;
            queue.add(new Cell(neighBouringRow,neighBouringColumn));
          }
      }

    }
  }

  private boolean isValidNeighBour(int neighBouringRow, int neighBouringColumn,int[][] grid) {

    if(neighBouringRow >=0 && neighBouringRow< grid.length && neighBouringColumn >=0 && neighBouringColumn< grid[0].length)
    {
      if(grid[neighBouringRow][neighBouringColumn] ==1)
        return true;
      else
        return false;
    }
    return false;
  }

}
