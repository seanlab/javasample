package me.seanxiao.leetcode;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        if (root == null) {
            return results;
        }
        nodes.add(root);
        while (!nodes.isEmpty()) {
            ArrayList<TreeNode> temp = new ArrayList<TreeNode>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < nodes.size(); i++) {
                result.add(nodes.get(i).val);
                if (nodes.get(i).left != null) {
                    temp.add(nodes.get(i).left);
                }
                if (nodes.get(i).right != null) {
                    temp.add(nodes.get(i).right);
                }
            }
            results.add(result);
            nodes = temp;
        }
        return results;
    }
}
