package org.coding.graph.shortestPathInBinaryWeightedGraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class ShortestPathInBinaryWeightedGraph {
  private static ArrayList<ArrayList<WeightedNode>> adjacencyList = new ArrayList<>();
  static class  WeightedNode
  {
    public  WeightedNode(int node, int weight) {
      this.node = node;
      this.weight = weight;
    }

    int node;
    int weight;
  }

  public static void main(String[] args) {


    int v = 9; //number of vertices

    for(int i =0; i < v; i++)
    {
       adjacencyList.add(new ArrayList<>());
    }

    addNode(0,1,0);
    addNode(0,7,1);
    addNode(1,7,1);
    addNode(1,2,1);
    addNode(7,8,1);
    addNode(7,6,1);
    addNode(6,8,1);
    addNode(8,2,1);
    addNode(2,5,0);
    addNode(6,5,1);
    addNode(2,3,0);
    addNode(5,3,1);
    addNode(3,4,1);
    addNode(5,4,1);

      for(int i:findShortestDistanceFromSourceToEveryNode(v,adjacencyList))
      {
      System.out.print(i+" ");
      }

  }

  public static void addNode(int sourceNode,int destinationNode ,int weight )
  {
     adjacencyList.get(sourceNode).add(new WeightedNode(destinationNode,weight));
    adjacencyList.get(destinationNode).add(new WeightedNode(sourceNode,weight));
  }

  public static Integer[] findShortestDistanceFromSourceToEveryNode(int v,ArrayList<ArrayList<WeightedNode>> adjacencyList  )
  {
        Integer[] distanceArray = new Integer[v];
        distanceArray[0] =0;

       Deque<WeightedNode> deQueue = new ArrayDeque();
       deQueue.addFirst(new WeightedNode(0,0));

       while(!deQueue.isEmpty())
       {
         WeightedNode weightedNode = deQueue.pollFirst();
         for(WeightedNode neighBouringNode : adjacencyList.get(weightedNode.node))
         {
            int neighBouringNodeWeight = distanceArray[weightedNode.node] + neighBouringNode.weight;
            if(distanceArray[neighBouringNode.node] ==null)
            {
              addToQueue(distanceArray,
                  (Deque<WeightedNode>) deQueue,
                  neighBouringNode, neighBouringNodeWeight);

            }

            if(distanceArray[neighBouringNode.node] > neighBouringNodeWeight )
            {
              addToQueue(distanceArray, deQueue, neighBouringNode, neighBouringNodeWeight);

            }
         }
       }

    return distanceArray;
  }

  private static void addToQueue(Integer[] distanceArray, Deque<WeightedNode> deQueue,
      WeightedNode neighBouringNode, int neighBouringNodeWeight) {
    distanceArray[neighBouringNode.node] = neighBouringNodeWeight;
    if (neighBouringNode.weight == 0) {
      deQueue.addFirst(neighBouringNode);
    } else {
      deQueue.addLast(neighBouringNode);
    }
  }

}
