package org.coding.tree.topview; // { Driver Code Starts
// Initial Template for Java

// Contributed by Sudarshan Sharma
import java.util.*;
import java.io.*;

class Node {
  int data;
  Node left, right;

  Node(int d) {
    data = d;
    left = right = null;
  }
}

class GfG {

  public static void main(String[] args) throws IOException {
    // Scanner sc=new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    while (t > 0) {
      Queue<Node> q = new LinkedList<>();

      int n = Integer.parseInt(br.readLine());
      String input[] = br.readLine().trim().split(" ");

      Node root = null;
      int j = 0;
      while (n > 0) {
        int a1 = Integer.parseInt(input[j]);
        int a2 = Integer.parseInt(input[j + 1]);
        char lr = input[j + 2].charAt(0);
        j += 3;

        if (root == null) {
          root = new Node(a1);
          q.add(root);
        }

        Node pick = q.peek();

        q.remove();

        if (lr == 'L') {
          pick.left = new Node(a2);
          q.add(pick.left);
        }
        a1 = Integer.parseInt(input[j]);
        a2 = Integer.parseInt(input[j + 1]);
        lr = input[j + 2].charAt(0);
        j += 3;

        if (lr == 'R') {
          pick.right = new Node(a2);
          q.add(pick.right);
        }

        n -= 2;
      }
      new View().topView(root);
      System.out.println();
      t--;
    }
  }
}

// } Driver Code Ends

// User function Template for Java

/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class View {
  // function should print the topView of the binary tree
  static void topView(Node root) {
    // add your code
    TreeMap<Integer, Integer> treeMap = levelOrderTraversal(root);

    for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
      System.out.print(entry.getValue() + " ");
    }
  }

  private static TreeMap<Integer, Integer> levelOrderTraversal(Node root) {
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    Queue<Map.Entry<Node, Integer>> queue = new LinkedList<>();
    queue.add(new AbstractMap.SimpleEntry<>(root, 0));

    while (!queue.isEmpty()) {
      Map.Entry<Node, Integer> entry = queue.remove();
      if (treeMap.get(entry.getValue()) == null) {
        treeMap.put(entry.getValue(), entry.getKey().data);
      }
      if (entry.getKey().left != null) {
        queue.add(new AbstractMap.SimpleEntry<>(entry.getKey().left, entry.getValue() - 1));
      }
      if (entry.getKey().right != null) {
        queue.add(new AbstractMap.SimpleEntry<>(entry.getKey().right, entry.getValue() + 1));
      }
    }
    return treeMap;
  }
}
