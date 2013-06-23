package me.seanxiao.leetcode;

public class InterleavingString {
    
    int[][] matrix;
    
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int i = 0;
        int j = 0;
        int k = 0;
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        matrix = new int[s1.length()][s2.length()];
        return solution(s1, s2, s3, i, j, k);
    }
    
    public boolean solution(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return true;
        }
        if (matrix[i][j] != 0) {
            return matrix[i][j] == 1; 
        }
        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = result || solution(s1, s2, s3, i + 1, j, k + 1);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = result || solution(s1, s2, s3, i, j + 1, k + 1);
        }
        matrix[i][j] = result ? 1 : -1;
        return result;
    }
    
    public static void main(String[] args) {
        InterleavingString obj = new InterleavingString();
        System.out.println(obj.isInterleave("aa", "ab", "aaba"));
    }
}
