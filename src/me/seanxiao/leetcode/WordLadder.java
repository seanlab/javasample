package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class WordLadder {

    Map<String, Integer> jumps = new HashMap<String, Integer>();
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<String> visited = new HashSet<String>();
        jumps = new HashMap<String, Integer>();
        List<String> array = new ArrayList<String>();
        array.add(start);
        Object[] candidates = dict.toArray();
        HashSet<String> checked = new HashSet<String>();
        int step = 1;
        while(!array.isEmpty()) {
            List<String> waitlist = new ArrayList<String>();
            while(!array.isEmpty()) {
                waitlist.add(array.get(0));
                array.remove(0);
            }
            for (int i = 0; i < waitlist.size(); i++) {
                String word = waitlist.get(i);
                if (visited.contains(word)) {
                    continue;
                }
                if (isOneStep(word, end)) {
                    return step + 1;
                }
                visited.add(word);
                for (int j = 0; j < candidates.length; j++) {
                    String candidate = (String)candidates[j];
                    if (isOneStep(candidate, word) && !checked.contains(candidate)) {
                        array.add(candidate);
                        checked.add(candidate);
                    }
                }
            }
            step++;
        }
        return 0;
    }
    
    public boolean isOneStep(String word1, String word2) {
        if (jumps.containsKey(word1 + "," + word2) || jumps.containsKey(word2 + "," + word1)) {
            return true;
        }
        if (word1.length() != word2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) count++;
        }
        if (count == 1) {
            jumps.put(word1 + "," + word2, 1);
            jumps.put(word2 + "," + word1, 1);
        }
        return count == 1;
    }
}
