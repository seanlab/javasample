package me.seanxiao.leetcode;

import java.util.ArrayList;

public class MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            ArrayList<TreeNode> temp = queue;
            queue = new ArrayList<TreeNode>();
            while (!temp.isEmpty()) {
                TreeNode node = temp.get(0);
                temp.remove(0);
                if (node.left == null && node.right == null) {
                    return count;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return count;
    }
}
