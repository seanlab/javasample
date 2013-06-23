package me.seanxiao.leetcode;


public class TrappingRainWater {
    
    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] array = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(array));
    }
    
    public int trap(int[] A) {
        int[] leftMost = new int[A.length];
        int min = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > min) {
                min = A[i];
            }
            leftMost[i] = min;
        }
        int total = 0;
        int right = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                right = A[i];
            }
            if (A[i] == leftMost[i] || A[i] > right) {
                right = A[i];
            }
            if (A[i] < right && A[i] < leftMost[i]) {
                total += Math.min(leftMost[i], right) - A[i];
            }
        }
        return total;
    }
}
