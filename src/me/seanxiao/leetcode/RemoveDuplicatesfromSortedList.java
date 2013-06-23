package me.seanxiao.leetcode;

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        if (head != null) {
            int current = temp.val;
            ListNode parent = temp;
            temp = temp.next;
            while (temp != null) {
                if (current != temp.val) {
                    parent.next = temp;
                    current = temp.val;
                    parent = temp;
                }
                temp = temp.next;
            }
            parent.next = null;
        }
        return head;
    }
}
