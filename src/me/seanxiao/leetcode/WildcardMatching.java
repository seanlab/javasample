package me.seanxiao.leetcode;

public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching obj = new WildcardMatching();
        obj.isMatch("mississippi", "m*si*");
    }
    
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        boolean star = true;
        for (i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            if (j >= p.length()) {
                return false;
            }
            char pChar = p.charAt(j);
            if (sChar == pChar) {
                j++;
            }
            else if (pChar == '?') {
                j++;
            }
            else if (pChar == '*') {
                star = true;
                int nextJ = j;
                while (nextJ < p.length() && p.charAt(nextJ) == '*') {
                    nextJ++;
                }
                if (nextJ == p.length()) {
                    return true;
                }
                j = nextJ - 1;
            }
            else {
                if(!star) {
                    return false;
                }
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}
