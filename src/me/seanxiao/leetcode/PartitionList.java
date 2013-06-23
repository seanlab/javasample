package me.seanxiao.leetcode;

public class PartitionList {

    public static void main(String[] args) {
        PartitionList obj = new PartitionList();
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        obj.partition(node1, 2);
    }
    
    public ListNode partition(ListNode head, int x) {
        ListNode firstHead = null;
        ListNode firstTemp = null;
        ListNode secondHead = null;
        ListNode secondTemp = null;
        
        ListNode temp = head;
        while (temp != null) {
            ListNode nextTemp = temp.next;

            if (temp.val < x) {
                if (firstHead == null) {
                    firstHead = temp;
                    firstTemp = temp;
                }
                else {
                    firstTemp.next = temp;
                    firstTemp = temp;
                }
            }
            else {
                if (secondHead == null) {
                    secondHead = temp;
                    secondTemp = temp;
                    secondTemp.next = null;
                }
                else {
                    secondTemp.next = temp;
                    secondTemp = temp;
                    secondTemp.next = null;
                }
            }
            temp = nextTemp;
        }
        if (firstHead == null) {
            return secondHead;
        }
        else {
            firstTemp.next = secondHead;
            return firstHead;
        }
    }
}
