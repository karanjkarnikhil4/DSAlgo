package org.coding.graph.detectCycleInDirectedGraph;

// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();

    while(t-- > 0)
    {
      ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      int V = sc.nextInt();
      int E = sc.nextInt();
      for(int i = 0; i < V+1; i++)
        list.add(i, new ArrayList<Integer>());
      for(int i = 0; i < E; i++)
      {
        int u = sc.nextInt();
        int v = sc.nextInt();
        list.get(u).add(v);
      }
      if(new Solution().isCyclic(V, list) == true)
        System.out.println("1");
      else System.out.println("0");
    }
  }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
//  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
//    Map<Integer,String> vertexColour = new HashMap<>();
//    for(int i =0; i< V; i++)
//    {
//      vertexColour.put(i,"W");
//    }
//    return detectCycle(0, adj,vertexColour);
//  }
//
//  boolean detectCycle(
//      int currentNode, ArrayList<ArrayList<Integer>> adj, Map<Integer, String> vertexColour) {
//    if (vertexColour.get(currentNode) == "W") {
//      vertexColour.put(currentNode, "G");
//
//      for (int neighbouringElement : adj.get(currentNode)) {
//
//        boolean isCycle = detectCycle(neighbouringElement, adj, vertexColour);
//        if (isCycle) {
//          return true;
//        }
//      }
//      vertexColour.put(currentNode, "B");
//    } else if (vertexColour.get(currentNode) == "G") {
//      return true;
//    }
//    return false;
//    }




  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    Map<Integer, String> vertexColour = new HashMap<>();
    for (int i = 0; i < V; i++) {
      vertexColour.put(i, "W");
    }

    for(int i =0;i<V; i++)
    {
        if(vertexColour.get(i)=="W")
        {
        if (detectCycle(i, adj, vertexColour)) {
          return true;
            }
        }
    }


    return false;
    }

  boolean detectCycle(
      int currentNode, ArrayList<ArrayList<Integer>> adj, Map<Integer, String> vertexColour) {
    if (vertexColour.get(currentNode) == "W") {
      vertexColour.put(currentNode, "G");

      for (int neighbouringElement : adj.get(currentNode)) {

        if(detectCycle(neighbouringElement, adj, vertexColour))
        {
          return true;
        }

      }
      vertexColour.put(currentNode, "B");
    } else if (vertexColour.get(currentNode) == "G") {
      return true;
    }
    return false;

  }
  }