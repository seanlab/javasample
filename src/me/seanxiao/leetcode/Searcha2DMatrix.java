package me.seanxiao.leetcode;

public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length - 1] > target) {
                return findInArray(matrix[i], target, 0, matrix[i].length);
            }
        }
        return false;
    }
    
    public boolean findInArray(int[] array, int target, int start, int end) {
        if (start >= end) return false;
        int middle = (end - start) / 2 + start;
        if (array[middle] == target) return true;
        if (array[middle] < target) {
            return findInArray(array, target, middle + 1, end);
        }
        else {
            return findInArray(array, target, start, middle - 1);
        }
    }
}
