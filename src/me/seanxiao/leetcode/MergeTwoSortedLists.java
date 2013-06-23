package me.seanxiao.leetcode;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        obj.mergeTwoLists(node1, new ListNode(0));
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        else {
            ListNode head = null;
            head = l1.val < l2.val ? l1 : l2;
            if (l1.val < l2.val) {
                l1 = l1.next;
            }
            else {
                l2 = l2.next;
            }
            ListNode temp = head;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    temp.next = l1;
                    temp = l1;
                    l1 = l1.next;
                }
                else {
                    temp.next = l2;
                    temp = l2;
                    l2 = l2.next;
                }
            }
            while (l1 != null) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            }
            while (l2 != null) {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
            return head;
        }
    }
}
