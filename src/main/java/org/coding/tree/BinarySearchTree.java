package org.coding.tree;

public class BinarySearchTree {

    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    boolean checkBST(Node root) {


        return IsSubTreeBst(root);

    }


    private Boolean IsSubTreeBst(Node node) {
        if (node == null) {
            return null;
        }

        Boolean isLeftTreeBst = IsSubTreeBst(node.left);
        Boolean isRightTreeBst = IsSubTreeBst(node.right);


        if(isLeftTreeBst ==null && isRightTreeBst ==null)
        {
            return true;
        }


      else  if (isLeftTreeBst && isRightTreeBst) {
           return (node.data > node.left.data && node
                    .data < node.right.data);
        }

      else if(isLeftTreeBst != null && isLeftTreeBst) {

            return (node.data > node.left.data);

        }

        else if(isRightTreeBst != null && isRightTreeBst) {

            return (node.data < node.right.data);

        }

        else
        {
            return true;
        }

    }
}
