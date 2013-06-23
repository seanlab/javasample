package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords obj = new SubstringwithConcatenationofAllWords();
        String[] L = {"foo", "bar"};
        System.out.println(obj.findSubstring("barfoothefoobarman", L));
    }

    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        if (L.length == 0) {
            return results;
        }

        Map<String, Integer> words = new HashMap<String, Integer>();
        for (int i = 0; i <= L.length; i++) {
            if (!words.containsKey(L[i])) {
                words.put(L[i], 0);
            }
            words.put(L[i], words.get(L[i]) + 1);
        }
        Map<String, Integer> count = new HashMap<String, Integer>();
        int worldLength = L[0].length();
        for (int i = 0; i < S.length() - worldLength * L.length; i++) {
            count.clear();
            int j = 0;
            for (; j < L.length; j++) {
                String subStr = S.substring(i + j * worldLength, i + (j + 1) * worldLength);
                if (!words.containsKey(subStr)) {
                    break;
                }
                if (!count.containsKey(subStr)) {
                    count.put(subStr, 0);
                }
                count.put(subStr, count.get(subStr) + 1);
                if (count.get(subStr) > words.get(subStr)) {
                    break;
                }
            }
            if (j == L.length) {
                results.add(i);
            }
        }
        return results;
    }
}
