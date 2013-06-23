package me.seanxiao.leetcode;

import java.util.Stack;

public class ReverseLinkedListII {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-1);
        ListNode node2 = new ListNode(-3);
        node1.next = node2;
        ReverseLinkedListII obj = new ReverseLinkedListII();
        obj.reverseBetween(node1, 1, 1);
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode root = head;
        ListNode last = null;
        ListNode temp = root;
        ListNode next = null;
        for (int i = 0; i < m - 1; i++) {
            last = temp;
            temp = temp.next;
        }
        Stack<ListNode> nodes = new Stack<ListNode>();
        for (int i = 0; i < n - m + 1; i++) {
            nodes.push(temp);
            temp = temp.next;
        }
        next = temp;
        if (last == null && !nodes.isEmpty()) {
            root = nodes.pop();
            last = root;
        }
        while (!nodes.isEmpty()) {
            last.next = nodes.pop();
            last = last.next;
        }
        last.next = next;
        return root;
    }
}
