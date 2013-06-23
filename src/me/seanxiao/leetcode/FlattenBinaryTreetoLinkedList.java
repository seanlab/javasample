package me.seanxiao.leetcode;


public class FlattenBinaryTreetoLinkedList {

    TreeNode rootNode;
    
    TreeNode lastNode;
    
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        else {
            rootNode = null;
            lastNode = null;
            root = rootNode;
        }
    }
    
    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        else {
            if (rootNode == null) {
                rootNode = new TreeNode(node.val);
                lastNode = rootNode;
            }
            else {
                TreeNode newNode = new TreeNode(node.val);
                lastNode.right = newNode;
                lastNode = newNode;
            }
            traverse(node.left);
            traverse(node.right);
        }
    }
}
