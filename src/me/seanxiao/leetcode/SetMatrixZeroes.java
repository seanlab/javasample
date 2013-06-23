package me.seanxiao.leetcode;

public class SetMatrixZeroes {
    
    int width;
    
    int height;
    
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        height = matrix.length;
        width = matrix[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) {
                    replace(matrix, i, j);
                }
            }
        }
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public void replace(int[][] matrix, int i, int j) {
        for (int m = 0; m < width; m++) {
            if (matrix[i][m] != 0) {
                matrix[i][m] = Integer.MAX_VALUE;
            }
        }
        for (int m = 0; m < height; m++) {
            if (matrix[m][j] != 0) {
                matrix[i][m] = Integer.MAX_VALUE;
            }
        }
    }
}
