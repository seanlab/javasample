package me.seanxiao.leetcode;

import java.util.ArrayList;

public class SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            ArrayList<TreeNode> temp = queue;
            queue = new ArrayList<TreeNode>();
            while (!temp.isEmpty()) {
                TreeNode node = temp.get(0);
                temp.remove(0);
                if (node.left == null && node.right == null) {
                    sum += node.val;
                }
                if (node.left != null) {
                    node.left.val = node.val * 10 + node.left.val;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 10 + node.right.val;
                    queue.add(node.right);
                }
            }
        }
        return sum;

    }
}
