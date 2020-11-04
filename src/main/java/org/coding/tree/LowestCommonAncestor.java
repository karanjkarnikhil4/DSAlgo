package org.coding.tree;

import java.util.Scanner;

//class MyNode {
//    MyNode left;
//    MyNode right;
//    int data;
//
//    MyNode(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}

public class LowestCommonAncestor {

    /*
    class Node
        int data;
        Node left;
        Node right;
    */
    public static Node lca(Node root, int v1, int v2) {
        if(root ==null)
        {
            return null;
        }

        Node leftNode = lca(root.left,v1,v2);
        Node rightNode = lca(root.right,v1,v2);

        if(leftNode!=null && rightNode!=null)
        {
            return root;
        }

        else if(leftNode != null &&(root.data == v1 || root.data ==v2))
        {
            return root;
        }

        else if(rightNode != null &&(root.data == v1 || root.data ==v2))
        {
            return root;
        }

        else if(root.data == v1 || root.data == v2)
        {
            return root;
        }

        else if( leftNode != null )
        {
            return leftNode;
        }

        else if( rightNode != null )
        {
            return rightNode;
        }
        else
        {
            return  null;
        }

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
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root, v1, v2);
        System.out.println(ans.data);
    }
}