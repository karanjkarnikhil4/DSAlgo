package org.coding.tree;

import java.util.Scanner;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class HeightOfTree {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */

    private static int maxheight =-1;
    public static int height(Node root) {

        int height = -1;
        if (root == null) {
            return height;
        }

        traverse(root,height);

        return maxheight;

    }

    public static void traverse(Node node, int height)
    {
        if(node != null)
        {
            height =height+1;

            if(height > maxheight)
            {
                maxheight = height;
            }
        }

        else
        {
            return;
        }

        traverse(node.left, height);
        traverse(node.right,height);


    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}