package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    ArrayList<Integer> result = new ArrayList<Integer>();
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<Integer>();
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        
        TreeNode current = root;
        while (!s.empty() || current != null) {
          if (current != null) {
            s.push(current);
            current = current.left;
          } else {
            current = s.peek();
            s.pop();
            result.add(current.val);
            current = current.right;
          }
        }
        return result;
    }
    
}
