package me.seanxiao.leetcode;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            int index = 1;
            for (int j = i; j - index >= 0 && j + index < s.length() - 1; index++) {
            }
        }
        return temp;
    }

}
