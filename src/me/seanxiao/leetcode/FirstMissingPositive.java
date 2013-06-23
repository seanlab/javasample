package me.seanxiao.leetcode;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] A) {
        if (A.length == 0) return 1;
        boolean[] positives = new boolean[A.length + 2];
        positives[0] = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 0 && A[i] < A.length + 2) {
                positives[A[i]] = true;
            }
        }
        for (int i = 0; i < positives.length; i++) {
            if (positives[i] == false) {
                return i;
            }
        }
        return 1;
    }
    
    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();
        int[] a = {1};
        obj.firstMissingPositive(a);
    }
}
