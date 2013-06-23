package me.seanxiao.leetcode;

public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        int length = len(head);
        TreeNode rootNode = makeTree(0, length - 1, head);
        return rootNode;
    }
    
    public TreeNode makeTree(int start, int end, ListNode node) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        ListNode p = node;
        for(int i = start; i < mid; i++) {
            p = p.next;
        }
        TreeNode newNode = new TreeNode(p.val);
        TreeNode leftNode = makeTree(start, mid - 1, node);
        TreeNode rightNode = makeTree(mid + 1, end, p.next);
        newNode.left = leftNode;
        newNode.right = rightNode;
        return newNode;
    }
    
    public int len(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
}
