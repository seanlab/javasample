package me.seanxiao.leetcode;

public class DecodeWays {
    
    int[] ways;
    
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ways = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ways[i] = 0;
        }
        int result = _solution(s, 0, 1, ways) + _solution(s, 0, 2, ways);
        return result;
    }
    
    public int _solution(String s, int start, int step, int[] ways) {
        if (start + step > s.length()) {
            return 0;
        }
        String subString = s.substring(start, start + step);
        if (subString.startsWith("0")) {
            return 0;
        }
        int value = Integer.parseInt(s.substring(start, start + step));
        if (value > 26 || value <= 0) {
            return 0;
        }
        if (start + step == s.length() && value <= 26 && value > 0) {
            return 1;
        }
        if (ways[start + step] != 0) {
            return ways[start + step];
        }
        else {
            int result = _solution(s, start + step, 1, ways) + _solution(s, start + step, 2, ways);
            ways[start + step] = result;
            return result;
        }
    }
    
    public static void main(String[] args) {
        DecodeWays obj = new DecodeWays();
        System.out.println(obj.numDecodings("129"));
    }
}
