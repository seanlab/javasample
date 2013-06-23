package me.seanxiao.leetcode;

public class DistinctSubsequences {

    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabit";
        DistinctSubsequences obj = new DistinctSubsequences();
        obj.numDistinct(s, t);
    }
    
    public int numDistinct(String S, String T) {
        int[] match = new int[T.length() + 1];
        if(S.length() < T.length()) {
            return 0;
        }
        match[0] = 1;
        for (int i = 1; i <= T.length(); i++) {
            match[i] = 0;
        }
        for(int i = 0; i< S.length(); i++) {
            for(int j = T.length(); j >= 1; j--) {
                if(S.charAt(i) == T.charAt(j - 1)) {
                    match[j] += match[j-1]; 
                }
            }
        }
        return match[T.length()];
    }
}
