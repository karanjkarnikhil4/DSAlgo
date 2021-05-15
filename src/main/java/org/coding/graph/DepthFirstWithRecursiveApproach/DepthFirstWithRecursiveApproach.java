package org.coding.graph.DepthFirstWithRecursiveApproach;

// { Driver Code Starts
// Initial Template for Java

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
  //  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
  //    boolean[] visited = new boolean[V];
  //    ArrayList<Integer> dfsTracedPath = new ArrayList<>(V);
  //    dfsOfGraph(0, adj, dfsTracedPath, visited);
  //
  //    return dfsTracedPath;
  //  }
  //
  //  private void dfsOfGraph(
  //      Integer root,
  //      ArrayList<ArrayList<Integer>> adj,
  //      ArrayList<Integer> dfsTracedPath,
  //      boolean[] visited) {
  //
  //    if (!visited[root]) {
  //      dfsTracedPath.add(root);
  //      visited[root] = true;
  //      for (int i : adj.get(root)) {
  //        dfsOfGraph(i, adj, dfsTracedPath, visited);
  //      }
  //    }
  //  }
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

    ArrayList<Integer> arrayList = new ArrayList<>();
    boolean[] visitedArray = new boolean[V];
    dfsCore(0, adj, visitedArray, arrayList);
    return arrayList;
  }

  private void dfsCore(
      int currentNode,
      ArrayList<ArrayList<Integer>> adj,
      boolean[] visitedArray,
      ArrayList<Integer> arrayList) {
    if (visitedArray[currentNode] != true) {
      visitedArray[currentNode] = true;
      arrayList.add(currentNode);
      for (int neighbouringElement : adj.get(currentNode)) {
        dfsCore(neighbouringElement, adj, visitedArray, arrayList);
      }
    }
  }
}
