package org.coding.tree;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class SolutionRightViewOfTree {
     int maxLevel =-1;
    public List<Integer> rightSideView(TreeNode root) {
        // Your code here

        ArrayList<Integer> list = new ArrayList<>();
        traversal(root, list, 0);

        return list;
    }


    private void traversal(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;
        else {
            if (maxLevel < level) {
                list.add(root.val);
                maxLevel = level;
            }

            // traverse right
            traversal(root.right, list, level + 1);

            // traverse left
            traversal(root.left, list, level + 1);

        }
    }
}
