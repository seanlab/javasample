package me.seanxiao.leetcode;

public class RotateList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        RotateList obje = new RotateList();
        obje.rotateRight(node1, 1);
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        int length = getLength(head);
        if (length == 0) {
            return null;
        }
        else {
            n = n % length;
            if (n == 0) {
                return head;
            }
            ListNode last = null;
            ListNode node = head;
            for (int i = 0; i < length - n; i++) {
                last = node;
                node = node.next;
            }
            ListNode temp = node;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = head;
            ListNode newHead = last.next;
            last.next = null;
            return newHead;
        }
    }
    
    public int getLength(ListNode node) {
        int count = 0;
        while (node != null) {
            node = node.next;
            count ++;
        }
        return count;
    }
}
