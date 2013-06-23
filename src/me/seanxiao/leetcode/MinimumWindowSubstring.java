package me.seanxiao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    
    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        obj.minWindow("ab", "b");
    }
    public String minWindow(String S, String T) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            char temp = T.charAt(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            }
            else {
                map.put(temp, 1);
            }
        }
        
        Map<Character, Integer> newMap = new HashMap<Character, Integer>(map);
        int startIndex = 0;
        int endIndex = 0;
        int minLength = S.length();
        String result = "";
        for (int i = 0; i < S.length(); i++) {
            startIndex = i;
            for (int j = i; j < S.length(); j++) {
                char c = S.charAt(j);
                if (newMap.containsKey(S.charAt(j))) {
                    newMap.put(c, newMap.get(c) - 1);
                    if (newMap.get(c) == 0) {
                        newMap.remove(c);
                    }
                    if (newMap.isEmpty()) {
                        endIndex = j;
                        if (endIndex - startIndex < minLength) {
                            minLength = endIndex - startIndex;
                            result = S.substring(startIndex, endIndex + 1);
                        }
                        for (;startIndex < endIndex; startIndex++) {
                            if (map.containsKey(S.charAt(startIndex))) {
                                startIndex--;
                                break;
                            }
                        }
                        i = startIndex;
                        break;
                    }
                }
            }
            newMap = new HashMap<Character, Integer>(map);
        }
        return result;
    }
}
