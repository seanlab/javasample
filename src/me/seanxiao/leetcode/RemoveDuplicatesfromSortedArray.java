package me.seanxiao.leetcode;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (A.length == 0) return 0;
        int length = 1;
        int current = A[0];
        A[0] = current;
        for (int i = 1; i < A.length; i++) {
            while(A[i] != current) {
                current = A[i];
                A[length++] = A[i];
            }
        }
        return length;
    }
}
