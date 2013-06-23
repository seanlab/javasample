package me.seanxiao.leetcode;

public class RemoveNthNodeFromEndofList {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode temp = head;
        ListNode fast = head;
        for (int i = 0; i < n - 1; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        ListNode parent = null;
        while (fast != null) {
            parent = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if (parent != null) {
            parent.next = slow.next;
        }
        return temp;
    }
}
