package me.seanxiao.leetcode;

import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {

    ArrayList<String> results;
    
    ArrayList<String> candidates;
    
    public ArrayList<String> letterCombinations(String digits) {
        candidates = new ArrayList<String>();
        candidates.add("");
        candidates.add("");
        candidates.add("abc");
        candidates.add("def");
        candidates.add("ghi");
        candidates.add("jkl");
        candidates.add("mno");
        candidates.add("pqrs");
        candidates.add("tuv");
        candidates.add("wxyz");
        results = new ArrayList<String>();
        add("", digits, 0);
        return results;
    }
    
    public void add(String result, String digits, int index) {
        if (index == digits.length()) {
            results.add(result);
        }
        else {
            int candidateIndex = digits.charAt(index) - '0';
            String candidate = candidates.get(candidateIndex);
            for (int i = 0; i < candidate.length(); i++) {
                String newResult = result + candidate.charAt(i);
                add(newResult, digits, index + 1);
            }
        }
    }
}
