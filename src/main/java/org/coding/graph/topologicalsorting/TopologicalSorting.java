package org.coding.graph.topologicalsorting;

// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader read =
        new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());

    while (t-- > 0) {
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      String st[] = read.readLine().trim().split("\\s+");
      int edg = Integer.parseInt(st[0]);
      int nov = Integer.parseInt(st[1]);

      for (int i = 0; i < nov + 1; i++)
        list.add(i, new ArrayList<Integer>());

      int p = 0;
      for (int i = 1; i <= edg; i++) {
        String s[] = read.readLine().trim().split("\\s+");
        int u = Integer.parseInt(s[0]);
        int v = Integer.parseInt(s[1]);
        list.get(u).add(v);
      }

      int[] res = new Solution().topoSort(nov, list);

      if (check(list, nov, res) == true)
        System.out.println("1");
      else
        System.out.println("0");
    }
  }
  static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
    int[] map = new int[V];
    for (int i = 0; i < V; i++) {
      map[res[i]] = i;
    }
    for (int i = 0; i < V; i++) {
      for (int v : list.get(i)) {
        if (map[i] > map[v]) return false;
      }
    }
    return true;
  }
}
// } Driver Code Ends
// } Driver Code Ends


/*Complete the function below*/

/*
ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
                                    and edges between them
N: represent number of vertices
*/
class Solution {
  private static Stack<Integer> stack = new Stack<Integer>();
  static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
    String[] vertexColor = new String[V];
    for (int i =0; i< V; i++)
    {
      vertexColor[i]= "W";
    }


    for(int i =0; i<V; i++)
    {
      if (vertexColor[i] == "W") {
        dfsCore(i, adj, vertexColor);
      }
    }
    int[] result = new int[V];
    if (!stack.isEmpty()) {
      for (int j = 0; j < V; j++) {
        result[j] = stack.pop();
      }
    }
    return result;
  }

  private static void dfsCore(int currentNode, ArrayList<ArrayList<Integer>> adj, String[] vertexColor ) {

    if(vertexColor[currentNode] == "W")
    {
      vertexColor[currentNode] = "G";
      for(int neighbouringElement: adj.get(currentNode))
      {
        dfsCore(neighbouringElement,adj,vertexColor);

      }
      vertexColor[currentNode] = "B";
      stack.push(currentNode);
    }

    else if(vertexColor[currentNode] == "G")
    {
      return;
    }

    else
    {
      return;
    }
  }
}