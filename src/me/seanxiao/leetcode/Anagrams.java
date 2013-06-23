package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<String, ArrayList<String>> maps = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!maps.containsKey(sorted)) {
                ArrayList<String> record = new ArrayList<String>();
                record.add(strs[i]);
                maps.put(sorted, record);
            }
            else {
                maps.get(sorted).add(strs[i]);
            }
        }
        ArrayList<String> results = new ArrayList<String>();
        for (String key: maps.keySet()) {
            if (maps.get(key).size() > 1) {
                results.addAll(maps.get(key));
            }
        }
        return results;
    }
}
