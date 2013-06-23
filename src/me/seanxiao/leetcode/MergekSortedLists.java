package me.seanxiao.leetcode;

import java.util.ArrayList;

public class MergekSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        ListNode node = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            node = mergeList(node, lists.get(i));
        }
        return node;
    }
    
    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode head = null;
        ListNode temp = null;
        ListNode current = null;
        if (head1 == null && head2 == null) {
            return null;
        }
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current = head1;
                head1 = head1.next;
            }
            else {
                current = head2;
                head2 = head2.next;
            }
            if (head == null) {
                head = current;
                temp = head;
            }
            else {
                temp.next = current;
                temp = temp.next;
            }
        }
        if (head1 != null) {
            if (head == null) {
                head = head1;
            }
            else {
                current.next = head1;
            }
        }
        else {
            if (head == null) {
                head = head2;
            }
            else {
                current.next = head2;
            }
        }
        return head;
    }
}
