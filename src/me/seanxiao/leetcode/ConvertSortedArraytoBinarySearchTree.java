package me.seanxiao.leetcode;

public class ConvertSortedArraytoBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int middle = num.length / 2;
        TreeNode root = new TreeNode(num[middle]);
        root.left = _solution(0, middle - 1, num);
        root.right = _solution(middle + 1, num.length - 1, num);
        return root;
    }
    
    public TreeNode _solution(int start, int end, int[] num) {
        if (start >= end) return null;
        else {
            int middle = (end - start) / 2 + start;
            TreeNode node = new TreeNode(num[middle]);
            node.left = _solution(start, middle - 1, num);
            node.right = _solution(middle + 1, end, num);
            return node;
        }
    }
    
}
