package org.coding.graph.depthFirstTraversal;

// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GFG {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      String[] s = br.readLine().trim().split(" ");
      int V = Integer.parseInt(s[0]);
      int E = Integer.parseInt(s[1]);
      ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
      for (int i = 0; i < E; i++) {
        String[] S = br.readLine().trim().split(" ");
        int u = Integer.parseInt(S[0]);
        int v = Integer.parseInt(S[1]);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }
      Solution obj = new Solution();
      ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
      for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
      System.out.println();
    }
  }
}
// } Driver Code Ends

class Solution {
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

    // Code here
    boolean[] visited = new boolean[V];
    ArrayList<Integer> dfsTrace = new ArrayList<>(V);
    Stack<Integer> stack = new Stack<>();
    stack.add(0);
    visited[0] = true;
    while (!stack.isEmpty()) {
      int poppedNode = stack.pop();
      dfsTrace.add(poppedNode);
      for (int node : adj.get(poppedNode)) {
        if (!visited[node]) {
          stack.push(node);
          visited[node] = true;
        }
      }
    }
    return dfsTrace;
  }
}
