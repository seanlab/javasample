package me.seanxiao.leetcode;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int index = 0;
        for (;index < A.length; index++) {
            if (A[index] >= target) {
                break;
            }
        }
        return index;
    }
}
