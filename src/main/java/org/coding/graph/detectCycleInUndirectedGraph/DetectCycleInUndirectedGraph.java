package org.coding.graph.detectCycleInUndirectedGraph;

// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int V = Integer.parseInt(s[0]);
      int E = Integer.parseInt(s[1]);
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
      for (int i = 0; i < E; i++) {
        String[] S = br.readLine().trim().split(" ");
        int u = Integer.parseInt(S[0]);
        int v = Integer.parseInt(S[1]);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      Solution obj = new Solution();
      boolean ans = obj.isCycle(V, adj);
      if (ans) System.out.println("1");
      else System.out.println("0");
    }
  }
} // } Driver Code Ends

class Solution {
  public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

    boolean[] visited = new boolean[V];
    int[] parent = new int[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        if(detectCycle(i, adj, visited, parent))
        {
          return true;
        }
      }
    }
    return false;
  }

  boolean detectCycle(int currentNode, ArrayList<ArrayList<Integer>> adj,  boolean[] visited, int[] parent)
  {
        visited[currentNode] = true;
        for(int neighbouringElement: adj.get(currentNode) )
        {
           if(visited[neighbouringElement] && parent[currentNode]!=neighbouringElement)
           {
                return true;
           }

           else if(!visited[neighbouringElement] )
           {
              parent[neighbouringElement]= currentNode;
              if(detectCycle(neighbouringElement,adj,visited,parent))
              {
                return true;
              }
           }
        }

        return false;

  }


}
