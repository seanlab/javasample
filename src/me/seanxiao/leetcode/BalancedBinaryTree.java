package me.seanxiao.leetcode;

public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        if (getHeight(root) == -1) {
            return false;
        }
        return true;
    }
    
    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int heightLeft = getHeight(node.left);
        if (heightLeft == -1) {
            return -1;
        }
        int heightRight = getHeight(node.right);
        if (heightRight == -1) {
            return -1;
        }
        if (Math.abs(heightRight - heightLeft) > 1) {
            return -1;
        }
        return Math.max(heightLeft, heightRight) + 1;
    }
}
