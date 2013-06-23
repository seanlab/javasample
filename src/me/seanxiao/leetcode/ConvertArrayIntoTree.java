package me.seanxiao.leetcode;


public class ConvertArrayIntoTree {

    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return _sortedArrayToBST(num, 0, num.length - 1);
    }

    public TreeNode _sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) return null;
        else {
            int middle = (end - start) / 2 + start;
            TreeNode node = new TreeNode(num[middle]);
            node.left = _sortedArrayToBST(num, start, middle - 1);
            node.right = _sortedArrayToBST(num, middle + 1, end);
            return node;
        }
    }
}
