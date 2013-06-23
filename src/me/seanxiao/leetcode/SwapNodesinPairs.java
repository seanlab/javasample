package me.seanxiao.leetcode;

public class SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode first = head;
        if (first == null) {
            return first;
        }
        ListNode second = first.next;
        while (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
            first = second.next;
            second = second.next;
            if (second == null) break;
            second = second.next;
        }
        return head;
    }
}
