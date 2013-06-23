package me.seanxiao.leetcode;

import java.util.ArrayList;

public class PalindromePartitioning {
    
    ArrayList<ArrayList<String>> results;
    
    public ArrayList<ArrayList<String>> partition(String s) {
        results = new ArrayList<ArrayList<String>>();
        _solution(new ArrayList<String>(), s);
        return results;
    }
    
    public void _solution(ArrayList<String> result, String s) {
        if (s.length() == 0) {
            results.add(result);
        }
        for (int i = 1; i <= s.length(); i++) {
            String subStr = s.substring(0, i);
            if (isPalindrome(subStr)) {
                ArrayList<String> newResult = new ArrayList<String>(result);
                String remain = s.substring(i);
                newResult.add(subStr);
                _solution(newResult, remain);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
