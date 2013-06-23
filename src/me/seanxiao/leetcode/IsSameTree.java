package me.seanxiao.leetcode;


public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if ((p == null && q != null) || (p != null && q == null)) return false;
        if (p.val != q.val) return false;
        else {
            boolean left = isSameTree(p.left, q.left);
            if (!left) return false;
            boolean right = isSameTree(p.right, q.right);
            return right;
        }
    }
}
