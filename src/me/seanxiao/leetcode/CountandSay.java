package me.seanxiao.leetcode;

public class CountandSay {

    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 1) return "1";
        String num = countAndSay(n - 1);
        char current = num.charAt(0);
        int count = 1;
        String result = "";
        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) != current) {
                result += count;
                result += current;
                current = num.charAt(i);
                count = 1;
            }
            else {
                count++;
            }
        }
        result += count;
        result += current;
        return result;
    }
}
