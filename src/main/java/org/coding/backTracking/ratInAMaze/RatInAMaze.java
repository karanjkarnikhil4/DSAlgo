package org.coding.backTracking.ratInAMaze;

// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int[][] a = new int[n][n];
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

      GfG g = new GfG();
      ArrayList<String> res = g.findPath(a, n);
      if (res.size() > 0) {
        for (int i = 0; i < res.size(); i++)
          System.out.print(res.get(i) + " ");
        System.out.println();
      } else {
        System.out.println(-1);
      }
    }
  }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class GfG {

  private static ArrayList<String> pathTraverse;
  public static ArrayList<String> findPath(int[][] m, int n) {
    // Your code here
    pathTraverse = new ArrayList<>();
    if(m[0][0]==0)
    {
      return pathTraverse;
    }
    m[0][0] =-1;
    traverseMaze(m,n,0,0,new ArrayList<String>());
    m[0][0] =1;
     Collections.sort(pathTraverse);
     return pathTraverse;
  }

  private static void printSolution(ArrayList<String> path)
  {
    StringBuilder stringBuilder = new StringBuilder();
    for(String direction:path)
    {
      stringBuilder.append(direction);
    }
  //  stringBuilder.append(" ");
    pathTraverse.add(stringBuilder.toString());
  }

  private static boolean isCellValid(int x, int y,int n, int[][] maze)
  {
    if((x >=0 && x<=n-1) &&(y>=0 && y<= n-1) && maze[x][y]==1)
    {
      return true;
    }
    return false;
  }

  private static void traverseMaze(int[][] maze,int n ,int i, int j,ArrayList<String> path)
  {

    if(i==n-1 && j==n-1)
    {
      printSolution(path);
      return;
    }

    int[] X = {0,-1,0,1};
    int[] Y = {-1,0,1,0};

    for(int k =0;k<X.length;k++)
    {
        int newX = i+X[k];
        int newY = j+Y[k];

        if(isCellValid(newX,newY,n,maze))
        {
          maze[newX][newY] =-1;
          if(k==0) path.add("L");
          if(k==1) path.add("U");
          if(k==2) path.add("R");
          if(k==3) path.add("D");
          traverseMaze(maze,n,newX,newY,path);
          maze[newX][newY] =1;
          path.remove(path.size()-1);
        }
    }

  }

}