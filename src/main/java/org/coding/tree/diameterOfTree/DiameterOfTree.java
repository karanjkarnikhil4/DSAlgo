package org.coding.tree.diameterOfTree;

// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}

class GfG {

  static Node buildTree(String str) {

    if (str.length() == 0 || str.charAt(0) == 'N') {
      return null;
    }

    String[] ip = str.split(" ");
    // Create the root of the tree
    Node root = new Node(Integer.parseInt(ip[0]));
    // Push the root to the queue

    Queue<Node> queue = new LinkedList<>();

    queue.add(root);
    // Starting from the second element

    int i = 1;
    while (queue.size() > 0 && i < ip.length) {

      // Get and remove the front of the queue
      Node currNode = queue.peek();
      queue.remove();

      // Get the current node's value from the string
      String currVal = ip[i];

      // If the left child is not null
      if (!currVal.equals("N")) {

        // Create the left child for the current node
        currNode.left = new Node(Integer.parseInt(currVal));
        // Push it to the queue
        queue.add(currNode.left);
      }

      // For the right child
      i++;
      if (i >= ip.length) break;

      currVal = ip[i];

      // If the right child is not null
      if (!currVal.equals("N")) {

        // Create the right child for the current node
        currNode.right = new Node(Integer.parseInt(currVal));

        // Push it to the queue
        queue.add(currNode.right);
      }
      i++;
    }

    return root;
  }

  static void printInorder(Node root) {
    if (root == null) return;

    printInorder(root.left);
    System.out.print(root.data + " ");

    printInorder(root.right);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      String s = br.readLine();
      Node root = buildTree(s);
      Tree g = new Tree();
      System.out.println(g.diameter(root));
      t--;
    }
  }
}
// } Driver Code Ends

// User function Template for Java

class Tree {

  /* Complete the function to get diameter of a binary tree */
  int diameter(Node root) {
    // Your code here
    return Diameter(root).diameter;
  }

  DiaHeight Diameter(Node root) {
    if (root == null) {
      return new DiaHeight(0, 0);
    } else {
      DiaHeight d1 = Diameter(root.left);
      DiaHeight d2 = Diameter(root.right);
      DiaHeight d =
          new DiaHeight(
              Math.max(Math.max(d1.diameter, d2.diameter), d1.height + d2.height + 1),
              Math.max(d1.height, d2.height) + 1);
      return d;
    }
  }

  class DiaHeight {
    int diameter;
    int height;

    public DiaHeight(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
    }
  }
}
