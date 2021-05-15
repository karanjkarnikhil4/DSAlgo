package org.coding.tree; /* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "MainPrepTech" only if the class is public. */
class PreOrderTraversal {

  public static void main(String[] args) throws java.lang.Exception {
    // your code goes here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());

      Node[] nodes = new Node[n];
      String[] inputdataForNodes = br.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        Node node = new Node(Integer.parseInt(inputdataForNodes[i]));
        nodes[i] = node;
      }
      for (int j = 0; j < n - 1; j++) {
        String[] edge = br.readLine().split(" ");
        if (Integer.parseInt(edge[2]) == 0) {
          nodes[Integer.parseInt(edge[0])].left = nodes[Integer.parseInt(edge[1])];
        } else {
          nodes[Integer.parseInt(edge[0])].right = nodes[Integer.parseInt(edge[1])];
        }
      }
      preOrder(nodes[0]);
    }
  }

  public static ArrayList<Integer> preOrder(Node root) {
    ArrayList<Integer> list = new ArrayList<>();
    preOrderTraversal(root, list);
    return list;
  }

  private static void preOrderTraversal(Node root, List<Integer> list) {
    if (root == null) {
      return;
    } else {
      list.add(root.data);
      preOrderTraversal(root.left, list);
      preOrderTraversal(root.right, list);
    }
  }
}
