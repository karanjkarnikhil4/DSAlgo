package org.coding.graph.minimumSpanningTree.primsAlgorithm;

// { Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class DriverClass
{
  public static void main(String args[]) throws IOException {

    BufferedReader read =
        new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String str[] = read.readLine().trim().split(" ");
      int V = Integer.parseInt(str[0]);
      int E = Integer.parseInt(str[1]);

      ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
      for(int i=0;i<V;i++)
      {
        adj.add(new ArrayList<ArrayList<Integer>>());
      }

      int i=0;
      while (i++<E) {
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

      Solution ob = new Solution();

      System.out.println(ob.spanningTree(V, adj));
    }
  }
}// } Driver Code Ends

// User function Template for Java

class Solution {

  static class WeightedNode implements Comparable<WeightedNode> {
    Integer weight;
    Integer node;

    public WeightedNode( int node,int weight) {
      this.weight = weight;
      this.node = node;
    }

    public int getWeight() {
      return weight;
    }

    public int getNode() {
      return node;
    }

    @Override
    public int compareTo(WeightedNode o) {
      return this.weight.compareTo(o.getWeight());
    }
  }

  static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    // Add your code here
    PriorityQueue<WeightedNode> priorityQueue =
        new PriorityQueue<>();

    boolean[] nodeIncluded = new boolean[V];

    priorityQueue.add(new WeightedNode(0,0));
    int spanningTreeWeight =0;

    while(!priorityQueue.isEmpty())
    {
      WeightedNode poppedNode = priorityQueue.poll();
      if(!nodeIncluded[poppedNode.node])
      {
        nodeIncluded[poppedNode.node] = true;
        spanningTreeWeight+=poppedNode.weight;
        ArrayList<ArrayList<Integer>> arrayListArrayList = adj.get(poppedNode.getNode());

        for(ArrayList<Integer> arrayList : arrayListArrayList)
        {
          if(!nodeIncluded[arrayList.get(0)])
          {
            WeightedNode weightedNode = new WeightedNode(arrayList.get(0),arrayList.get(1));
            priorityQueue.add(weightedNode);
          }
        }
      }
    }
    return spanningTreeWeight;
  }

}

