package me.seanxiao.leetcode;

public class PalindromePartitioningII {

    boolean[][] palindromes;

    public int minCut(String s) {
        int[] cuts = new int[s.length() + 1];
        palindromes = new boolean[s.length() + 1][s.length() + 1];
        match(s, 0, cuts);
        return cuts[0];
    }

    private int match(String s, int start, int[] cuts) {
        if (cuts[start] != 0) {
            return cuts[start];
        }
        if (s.length() == 1) {
            return cuts[start];
        }
        if (s.equals("")) {
            return -1;
        }
        else {
            int minCut = Integer.MAX_VALUE;
            for (int i = s.length(); i > 0 ; i--) {
                if (palindromes[start][start + i] || isPalindrome(s.substring(0, i))) {
                    palindromes[start][start + i] = true;
                    int result = 1 + match(s.substring(i), start + i, cuts);
                    if (result < minCut) {
                        minCut = result;
                        cuts[start] = minCut;
                    }
                }
            }
            return minCut;
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
