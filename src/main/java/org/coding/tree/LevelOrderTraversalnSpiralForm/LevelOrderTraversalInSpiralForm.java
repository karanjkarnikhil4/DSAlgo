package org.coding.tree.LevelOrderTraversalnSpiralForm;

// { Driver Code Starts
// Initial Template for Java

// Initial Template for Java

// Contributed by Sudarshan Sharma
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

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

    String ip[] = str.split(" ");
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

  void inOrder(Node node) {
    if (node == null) {
      return;
    }

    inOrder(node.left);
    System.out.print(node.data + " ");

    inOrder(node.right);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t-- > 0) {
      String s = br.readLine();
      Node root = buildTree(s);
      Spiral g = new Spiral();
      ArrayList<Integer> result = g.findSpiral(root);
      for (int value : result) System.out.print(value + " ");
      System.out.println();
    }
  }
}

// } Driver Code Ends

// User function Template for Java

/*
// A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/

class Spiral {
  ArrayList<Integer> findSpiral(Node root) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    arrayList = levelOrderTraversal(root);
    return arrayList;
  }

  private ArrayList<Integer> levelOrderTraversal(Node root) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();
    stack1.add(root);

    while (!stack1.isEmpty() || !stack2.empty()) {

      while (!stack1.isEmpty()) {
        Node node1 = stack1.pop();
        if (node1 != null) {
          arrayList.add(node1.data);

          if (node1.right != null) {
            stack2.add(node1.right);
          }

          if (node1.left != null) {
            stack2.add(node1.left);
          }
        }
      }

      while (!stack2.isEmpty()) {
        Node node2 = stack2.pop();
        if (node2 != null) {
          arrayList.add(node2.data);

          if (node2.left != null) {
            stack1.add(node2.left);
          }
          if (node2.right != null) {
            stack1.add(node2.right);
          }
        }
      }
    }
    return arrayList;
    }
  }
