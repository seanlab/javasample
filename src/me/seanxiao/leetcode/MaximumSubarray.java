package me.seanxiao.leetcode;

public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        int maxSum = Integer.MIN_VALUE;
        int max[] = new int[A.length];
        if (A.length > 0) {
            max[0] = A[0];
            if (maxSum < max[0]) {
                maxSum = max[0];
            }
        }
        for (int i = 1; i < A.length; i++) {
            max[i] = Math.max(A[i], max[i- 1] + A[i]);
            if (max[i] > maxSum) {
                maxSum = max[i];
            }
        }
        return maxSum;
    }
}
