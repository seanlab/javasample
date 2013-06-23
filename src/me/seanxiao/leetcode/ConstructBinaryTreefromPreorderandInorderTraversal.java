package me.seanxiao.leetcode;

import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal obj = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorder = {1,2,3};
        int[] inorder = {2,3,1};
        obj.buildTree(preorder, inorder);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        int i = 0;
        int j = 0;
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        TreeNode currentNode = null;
        TreeNode lastLeftNode = null;
        TreeNode lastNode = null;
        while (i < preorder.length && j < inorder.length || !nodeStack.isEmpty()) {
            if (nodeStack.isEmpty() || !nodeStack.isEmpty() && nodeStack.peek().val != inorder[j] && i < preorder.length) {
                currentNode = new TreeNode(preorder[i]);
                if (root == null) {
                    root = currentNode;
                }
                if (lastNode != null) {
                    lastNode.right = currentNode;
                    lastLeftNode = null;
                    lastNode = null;
                }
                if (lastLeftNode == null) {
                    lastLeftNode = currentNode;
                }
                else {
                    lastLeftNode.left = currentNode;
                    lastLeftNode = currentNode;
                }
                
                nodeStack.push(currentNode);
                i++;
            }
            else {
                lastNode = nodeStack.pop();
                j++;
                while (j < inorder.length && !nodeStack.isEmpty() && inorder[j] == nodeStack.peek().val) {
                    currentNode = nodeStack.pop();
                    lastNode = currentNode;
                    j++;
                }
            }
        }
        return root;
    }
}
