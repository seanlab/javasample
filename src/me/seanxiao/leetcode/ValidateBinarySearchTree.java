package me.seanxiao.leetcode;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return testSubTree(root.left, Integer.MIN_VALUE, root.val) && testSubTree(root.right, root.val, Integer.MAX_VALUE);
    }
    
    public boolean testSubTree(TreeNode node, int start, int end) {
        if (node == null) {
            return true;
        }
        if (node.val <= start || node.val >= end) {
            return false;
        }
        return testSubTree(node.left, start, node.val) && testSubTree(node.right, node.val, end);
    }
}
