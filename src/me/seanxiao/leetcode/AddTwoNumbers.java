package me.seanxiao.leetcode;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int incr = 0;
        ListNode return1 = l1;
        ListNode return2 = l2;
        ListNode p = null;
        while (l1 != null && l2 != null) {
            int temp = l1.val + l2.val + incr;
            l1.val = temp % 10;
            incr = temp / 10;
            p = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (p != null) {
            while (l1 != null) {
                int temp = l1.val + incr;
                l1.val = temp % 10;
                incr = temp / 10;
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }
            while (l2 != null) {
                int temp = l2.val + incr;
                l2.val = temp % 10;
                incr = temp / 10;
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
            if (incr == 1) {
                p.next = new ListNode(incr);
            }
        }
        else {
            return return2;
        }
        return return1;
    }
}
