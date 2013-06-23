package me.seanxiao.leetcode;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lastLength = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                lastLength = length;
                length = 0;
            }
            else {
                length++;
            }
        }
        if (length != 0) {
            lastLength = length;
        }
        return lastLength;
    }
}
