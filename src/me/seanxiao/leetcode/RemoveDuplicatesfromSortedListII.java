package me.seanxiao.leetcode;


public class RemoveDuplicatesfromSortedListII {

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedListII obj = new RemoveDuplicatesfromSortedListII();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        obj.deleteDuplicates(node1);
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        ListNode newTemp = null;
        ListNode temp = head;
        while (temp != null) {
            boolean find = false;
            ListNode tempNext = temp.next;
            while (temp.next != null && temp.next.val == temp.val) {
                find = true;
                temp = temp.next;
                tempNext = temp.next;
            }
            if (!find) {
                if (newHead == null) {
                    newHead = temp;
                    newTemp = newHead;
                    newTemp.next = null;
                }
                else {
                    newTemp.next = temp;
                    newTemp = newTemp.next;
                    newTemp.next = null;
                }
            }
            temp = tempNext;
        }
        return newHead;
    }
}
