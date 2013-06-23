package me.seanxiao.leetcode;

public class ZigZagConversion {

    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }
        String[] rows = new String[nRows];
        int inc = 1;
        int index = 0;
        for (int i = 0; i < nRows; i++) {
            rows[i] = "";
        }
        for (int i = 0; i < s.length(); i++) {
            rows[index] += s.charAt(i);
            index += inc;
            if (index == nRows - 1) {
                inc = -1;
            }
            else if (index == 0) {
                inc = 1;
            }
        }
        String result = "";
        for (int i = 0; i < nRows; i++) {
            result += rows[i];
        }
        return result;
    }
}
