package me.seanxiao.leetcode;


public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode current) {
        if (current == null) {
            return;
        }
        if (current.left == null && current.right == null) {
            return;
        }
        else if (current.left != null || current.right != null) {
            flatten(current.left);
            flatten(current.right);
            TreeNode temp = current.left;
            if (temp != null) {
                while (temp.right != null) {
                    temp = temp.right;
                }
                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
        }
    }
}
