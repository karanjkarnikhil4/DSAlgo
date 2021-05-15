package org.coding.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeightOfBinaryTreeImproved {

  public static void main(String[] args) throws IOException {
    //
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
      int height = 0;
      System.out.println(heightOfTree(nodes[0], height));
    }
  }

  private static int heightOfTree(Node root, int height) {
    if (root == null) {
      return 0;
    } else {
      height = Math.max(heightOfTree(root.left, height), heightOfTree(root.right, height));
      height= height+1;
      return height;
    }
  }
}
