package me.seanxiao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, String> symbols = new HashMap<Integer, String>();
        symbols.put(1, "I");
        symbols.put(5, "V");
        symbols.put(10, "X");
        symbols.put(50, "L");
        symbols.put(100, "C");
        symbols.put(500, "D");
        symbols.put(1000, "M");
        String result = "";
        int count = 0;
        while (num != 0) {
            String part = "";
            int value = num % 10;
            int actual = (int)(value * Math.pow(10, count));
            if (value <= 3) {
                for (int i = 0; i < value; i++) {
                    part += symbols.get(actual / value);
                }
            }
            else if (value == 4) {
                part += symbols.get(actual / value) + symbols.get(actual + actual / value);
            }
            else if (value == 5) {
                part += symbols.get(actual);
            }
            else if (value <= 8) {
                part += symbols.get((int)(5 * Math.pow(10, count)));
                for (int i = 0; i < value - 5; i++) {
                    part += symbols.get(actual / value);
                }
            }
            else if (value == 9) {
                part += symbols.get(actual / value);
                part += symbols.get(actual + actual / value);
            }
            result = part + result;
            num = num / 10;
            count++;
        }
        return result;
    }
}
