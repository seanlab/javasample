package me.seanxiao.leetcode;


public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int length = 1;
        int current = A[0];
        A[0] = current;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == current) {
                count++;
            }
            else {
                current = A[i];
                count = 1;
            }
            if (count <= 2) {
                A[length++] = A[i];
            }
        }
        return length;
    }
}
