package me.seanxiao.leetcode;

public class AddBinary {

    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i;
        int j;
        int inc = 0;
        String result = "";
        for (i = a.length() - 1, j = b.length() - 1; i >= 0 && j >=0; i--, j--) {
            int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + inc;
            inc = sum / 2;
            result = sum % 2 + result;
        }
        if (i != -1) {
            for (; i >= 0; i--) {
                int sum = a.charAt(i) - '0' + inc;
                inc = sum / 2;
                result = sum % 2 + result;
            }
        }
        if (j != -1) {
            for (; j >= 0; j--) {
                int sum = b.charAt(j) - '0' + inc;
                inc = sum / 2;
                result = sum % 2 + result;
            }
        }
        if (inc != 0) {
            result = inc + result;
        }
        return result;
    }
}
