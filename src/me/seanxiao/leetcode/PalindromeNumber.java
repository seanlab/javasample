package me.seanxiao.leetcode;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber obj = new PalindromeNumber();
        obj.isPalindrome(1);
    }
    
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int length = 0;
        int temp = x;
        while (temp != 0) {
            length++;
            temp /= 10;
        }
        if (length == 1 || length == 0) {
            return true;
        }
        else {
            temp = x;
            while (temp != 0 && length > 0) {
                int tail = temp % 10;
                int head = (int) (temp / Math.pow(10, length - 1));
                if (tail != head) {
                    return false;
                }
                temp = (int) (temp - head * Math.pow(10, length - 1));
                temp /= 10;
                length -= 2;
            }
        }
        return true;
    }
}
