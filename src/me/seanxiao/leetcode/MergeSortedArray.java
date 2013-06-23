package me.seanxiao.leetcode;

public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int k = m + n - 1;
        int i = m - 1, j = n - 1;
        for (; i >= 0 && j >= 0;) {
            if (A[i] < B[j]) {
                A[k--] = B[j--];
            }
            else {
                A[k--] = A[i--];
            }
        }
        if (i == -1) {
            while (j >= 0) {
                A[k--] = B[j--];
            }
        }
    }
}
