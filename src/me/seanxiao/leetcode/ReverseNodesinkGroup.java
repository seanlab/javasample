package me.seanxiao.leetcode;

import java.util.Stack;

public class ReverseNodesinkGroup {

    public static void main(String[] args) {
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode newHead = null;
        ListNode temp = head;
        ListNode lastCurrent = null;
        ListNode lastStop = null;
        while (temp != null) {
            ListNode nextTemp = temp.next;
            if (stack.size() == k) {
                while (!stack.empty()) { 
                    if (newHead == null) {
                        newHead = stack.peek();
                    }
                    if (lastStop != null) {
                        lastStop.next = stack.peek();
                        lastStop = null;
                    }
                    if (lastCurrent == null) {
                        lastCurrent = stack.peek();
                        lastCurrent.next = null;
                    } else {
                        lastCurrent.next = stack.peek();
                        lastCurrent = lastCurrent.next;
                        lastCurrent.next = null;
                    }
                    stack.pop();
                }
            }
            if (lastCurrent != null) {
                lastCurrent.next = temp;
                lastStop = lastCurrent;
                lastCurrent = null;
            }
            stack.push(temp);
            temp = nextTemp;
        }
        if (stack.size() == k) {
            while (!stack.empty()) {
                if (newHead == null) {
                    newHead = stack.peek();
                }
                if (lastStop != null) {
                    lastStop.next = stack.peek();
                    lastStop = null;
                }
                if (lastCurrent == null) {
                    lastCurrent = stack.peek();
                    lastCurrent.next = null;
                } else {
                    lastCurrent.next = stack.peek();
                    lastCurrent = lastCurrent.next;
                    lastCurrent.next = null;
                }
                stack.pop();
            }
        }
        return newHead == null ? head : newHead;
    }
}
