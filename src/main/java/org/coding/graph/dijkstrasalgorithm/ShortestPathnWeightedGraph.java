package org.coding.graph.dijkstrasalgorithm;

// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class DriverClass {
  public static void main(String args[]) throws IOException {

    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String str[] = read.readLine().trim().split(" ");
      int V = Integer.parseInt(str[0]);
      int E = Integer.parseInt(str[1]);

      ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
      for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<ArrayList<Integer>>());
      }
      int i = 0;
      while (i++ < E) {
        String S[] = read.readLine().trim().split(" ");
        int u = Integer.parseInt(S[0]);
        int v = Integer.parseInt(S[1]);
        int w = Integer.parseInt(S[2]);
        ArrayList<Integer> t1 = new ArrayList<Integer>();
        ArrayList<Integer> t2 = new ArrayList<Integer>();
        t1.add(v);
        t1.add(w);
        t2.add(u);
        t2.add(w);
        adj.get(u).add(t1);
        adj.get(v).add(t2);
      }

      int S = Integer.parseInt(read.readLine());

      Solution ob = new Solution();

      int[] ptr = ob.dijkstra(V, adj, S);

      for (i = 0; i < V; i++) System.out.print(ptr[i] + " ");
      System.out.println();
    }
  }
} // } Driver Code Ends

// User function Template for Java

/*
 *   adj: vector of vectors which represents the graph
 *   S: source vertex to start traversing graph with
 *   V: number of vertices
 */
class Solution {

  static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
    PriorityQueue<DistanceNode> priorityQueue = new PriorityQueue<>();

    int[] distances = new int[V];

    for (int i = 0; i < V; i++) {
      distances[i] = Integer.MAX_VALUE;
    }
    distances[S] = 0;
    priorityQueue.add(new DistanceNode(S, 0));

    while (!priorityQueue.isEmpty()) {
      DistanceNode polledNode = priorityQueue.poll();

      for (ArrayList<Integer> neighBouringNodes : adj.get(polledNode.node)) {
        int neighBouringNodeDistance = polledNode.distance + neighBouringNodes.get(1);
        if (distances[neighBouringNodes.get(0)] > neighBouringNodeDistance) {
          distances[neighBouringNodes.get(0)] = neighBouringNodeDistance;
          priorityQueue.add(new DistanceNode(neighBouringNodes.get(0), neighBouringNodeDistance));
        }
      }
    }
    return distances;
  }

  static class DistanceNode implements Comparable<DistanceNode> {

    Integer node;
    Integer distance;

    public DistanceNode(Integer node, Integer distance) {
      this.node = node;
      this.distance = distance;
    }

    public Integer getNode() {
      return node;
    }

    public Integer getDistance() {
      return distance;
    }

    @Override
    public int compareTo(DistanceNode o) {
      return this.distance.compareTo(o.distance);
    }
  }
}
