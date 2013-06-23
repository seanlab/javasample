package me.seanxiao.leetcode;

import java.util.ArrayList;

public class PathSumII {

    ArrayList<ArrayList<Integer>> results;
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        PathSumII obj = new PathSumII();
        obj.pathSum(root, 3);
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        results = new ArrayList<ArrayList<Integer>>();
        solution(root, sum, new ArrayList<Integer>());
        return results;
    }
    
    public void solution(TreeNode node, int remain, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        else {
            result.add(node.val);
            if (remain == node.val && node.left == null && node.right == null) {
                results.add(result);
            }
            solution(node.left, remain - node.val, new ArrayList<Integer>(result));
            solution(node.right, remain - node.val, new ArrayList<Integer>(result));
        }
    }
}
