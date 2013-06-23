package me.seanxiao.leetcode;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        else {
            return _solution(root.left, root.right);
        }
    }
    
    public boolean _solution(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return _solution(left.left, right.right) && _solution(left.right, right.left);
    }

    
}
