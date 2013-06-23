package me.seanxiao.leetcode;

public class StrStr {

    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (haystack.equals(needle)) {
            return needle;
        }
        for (int i = 0; i < haystack.length() - needle.length(); i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if (i + j < haystack.length() && needle.charAt(j) != haystack.charAt(i + j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}
