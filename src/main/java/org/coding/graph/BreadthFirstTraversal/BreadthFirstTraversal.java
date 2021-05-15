package org.coding.graph.BreadthFirstTraversal;

// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        // adj.get(v).add(u);
      }
      Solution obj = new Solution();
      ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
      for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
      System.out.println();
    }
  }
}
// } Driver Code Ends

class Solution {
  //  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
  //    // Code here
  //    boolean[] visited = new boolean[V];
  //    ArrayList<Integer> bfsTrace = new ArrayList<>(V);
  //    Queue<Integer> queue = new LinkedList<>();
  //    queue.add(0);
  //    visited[0] = true;
  //    while (!queue.isEmpty()) {
  //      int poppedNode = queue.poll();
  //      bfsTrace.add(poppedNode);
  //      for (int node : adj.get(poppedNode)) {
  //        if (!visited[node]) {
  //          queue.add(node);
  //          visited[node] = true;
  //        }
  //      }
  //    }
  //    return bfsTrace;
  //  }

  public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
    ArrayList<Integer> bfsPath = new ArrayList<>();
    boolean[] visited = new boolean[V];
    Queue<Integer> nodeQueue = new LinkedList<>();
    nodeQueue.add(0);
    visited[0] = true;

    while (!nodeQueue.isEmpty()) {
      int currentNode = nodeQueue.poll();
      bfsPath.add(currentNode);

      for (int neighbouringElement : adj.get(currentNode)) {
        if (visited[neighbouringElement] == false) {
          visited[neighbouringElement] = true;
          nodeQueue.add(neighbouringElement);
        }
      }
    }

    return bfsPath;
  }
}
