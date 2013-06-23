package me.seanxiao.leetcode;

public class StringtoInteger {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        long result = 0;
        boolean negtive = false;
        boolean start = true;
        for (int i = 0; i < str.length();i++) {
            if (start && str.charAt(i) == '-') {
                start = false;
                negtive = true;
            }
            else if (start && str.charAt(i) == '+') {
                negtive = false;
                start = false;
            }
            else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                start = false;
                result = result * 10 + str.charAt(i) - '0';
            }
            else {
                if (str.charAt(i) != ' ') start = false;
                if (!start) break;
            }
        }
        result = negtive ? -result : result;
        if (result > Integer.MAX_VALUE) result = Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE) result = Integer.MIN_VALUE;
        return (int)result;
    }
    
    public static void main(String[] args) {
        StringtoInteger obj = new StringtoInteger();
        obj.atoi("-2147483648");
    }
}
