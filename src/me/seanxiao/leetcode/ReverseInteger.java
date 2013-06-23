package me.seanxiao.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 0) {
            return -reverse(-x);
        }
        int result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
