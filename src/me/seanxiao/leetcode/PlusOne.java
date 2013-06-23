package me.seanxiao.leetcode;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int inc = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int result;
            if (i == digits.length - 1) {
                result = digits[i] + 1 + inc;
            }
            else {
                result = digits[i] + inc;
            }
            digits[i] = result % 10;
            inc = result / 10;
        }
        if (inc != 0) {
            int[] results = new int[digits.length + 1];
            results[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                results[i + 1] = digits[i];
            }
            return results;
        }
        return digits;
    }
}
