package me.seanxiao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        obj.lengthOfLongestSubstring("abcabcde");
    }
    
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLentgh = 0;
        int currentLength = 0;
        for (int i = 0; i < s.length();) {
            boolean shouldBreak = true;
            for (int j = i; j < s.length(); j++) {
                if (!map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), j);
                    currentLength++;
                }
                else {
                    if (currentLength > maxLentgh) {
                        maxLentgh = currentLength;
                    }
                    i = map.get(s.charAt(j)) + 1;
                    currentLength = 0;
                    map = new HashMap<Character, Integer>();
                    shouldBreak = false;
                    break;
                }
            }
            if (shouldBreak == true) {
                if (currentLength > maxLentgh) {
                    maxLentgh = currentLength;
                }
                break;
            }
        }
        return maxLentgh;
    }
    
}
