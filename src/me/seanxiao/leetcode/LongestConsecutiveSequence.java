package me.seanxiao.leetcode;

import java.util.HashMap;
import java.util.Map;


public class LongestConsecutiveSequence {
    
    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int[] array = {0};
        obj.longestConsecutive(array);
    }
    
    int maxLength;
    Map<Integer, Integer> numMaps;
    
    public int longestConsecutive(int[] num) {
        maxLength = 0;
        numMaps = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            numMaps.put(num[i], 1);
        }
        for (Integer key : numMaps.keySet()) {
            if (numMaps.get(key) == 1) {
                testConsecutive(key);
            }
        }
        return maxLength;
    }
    
    public void testConsecutive(int start) {
        numMaps.put(start, 0);
        int len = 1;
        int temp = start;
        while(true) {
            temp++;
            if (numMaps.containsKey(temp) && numMaps.get(temp) == 1) {
                numMaps.put(temp, 0);
                len++;
            }
            else {
                break;
            }
        }
        temp = start;
        while(true) {
            temp--;
            if (numMaps.containsKey(temp) && numMaps.get(temp) == 1) {
                numMaps.put(temp, 0);
                len++;
            }
            else {
                break;
            }
        }
        if (len > maxLength) {
            maxLength = len;
        }
    }
}
