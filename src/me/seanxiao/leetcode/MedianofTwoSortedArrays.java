package me.seanxiao.leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        MedianofTwoSortedArrays obj = new MedianofTwoSortedArrays();
        int[] A = {1,1};
        int[] B = {1,2};
        obj.findMedianSortedArrays(A, B);
    }
    
    public double findMedianSortedArrays(int A[], int B[]) {
        if ((A.length + B.length) % 2 == 0) {
            return (getKth(A, B, (A.length + B.length) / 2) + getKth(A, B, (A.length + B.length) / 2 + 1)) / 2.0;
        }
        else {
            return getKth(A, B, (A.length + B.length) / 2 + 1);
        }
    }

    public int getKth(int A[], int B[], int k) {
        if (A.length == 0) {
            return B[k - 1];
        }
        if(B.length == 0) {
            return A[k - 1];
        }
        if (k <= 1) {
            return Math.min(A[0], B[0]);
        }
        if (A[A.length / 2] <= B[B.length / 2]) {
            if (A.length / 2 + B.length / 2 + 1 >= k) {
                return getKth(A, Arrays.copyOf(B, B.length / 2), k);
            }
            else {
                return getKth(Arrays.copyOfRange(A, A.length / 2 + 1, A.length), B, k - A.length / 2 - 1);
            }
        }
        else {
            if (A.length / 2 + B.length / 2 + 1 >= k) {
                return getKth(Arrays.copyOf(A, A.length / 2), B, k);
            }
            else {
                return getKth(A, Arrays.copyOfRange(B, B.length / 2 + 1, B.length), k - B.length / 2 - 1);
            }
        }
    }
}
