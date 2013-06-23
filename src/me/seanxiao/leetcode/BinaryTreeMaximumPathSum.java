package me.seanxiao.leetcode;

public class BinaryTreeMaximumPathSum {

    private int maxValue;
    
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        _maxPathSum(root);
        return maxValue;
    }
    
    public int _maxPathSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        else {
            int left = _maxPathSum(node.left);
            int right = _maxPathSum(node.right);
            int total = node.val;
            if (left >= 0) {
                total += left;
            }
            if (right >= 0) {
                total += right;
            }
            if (total > maxValue) {
                maxValue = total;
            }
            return Math.max(Math.max(node.val, node.val + left), node.val + right);
        }
    }
}
