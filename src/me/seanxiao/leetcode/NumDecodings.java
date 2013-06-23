package me.seanxiao.leetcode;

public class NumDecodings {
    
    int results[];

    public int numDecodings(String s) {
        results = new int[s.length()];
        for (int i = 0; i < results.length; i++) {
            results[i] = -1;
        }
        return _numDecoding(s, 0);
    }
    
    public int _numDecoding(String s, int index) {
        int num = 0;
        if (results[index] != -1) {
            return results[index];
        }
        if (s.length() == 0) return 0;
        else if (s.charAt(0) == '0') return 0;
        else if (s.length() == 1) return 1;
        else if (s.length() == 2 && s.charAt(0) == '1' && s.charAt(1) == '0') return 1;
        else if (s.length() == 2 && s.charAt(0) == '2' && s.charAt(1) == '0') return 1;
        else if (s.length() == 2 && (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) <= '6')) return 2;
        else {
            if (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) <= '6') {
                num += _numDecoding(s.substring(2), index + 2);
            }
            num += _numDecoding(s.substring(1), index + 1);
        }
        results[index] = num;
        return num;
    }
}
