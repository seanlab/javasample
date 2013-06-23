package me.seanxiao.leetcode;

import java.util.ArrayList;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[] vector1 = {1,2,3,4,5,6,7,8,9,10};
        int[] vector2 = {11,12,13,14,15,16,17,18,19,20};
        int[][] matrix = {vector1, vector2};
        SpiralMatrix obj = new SpiralMatrix();
        obj.spiralOrder(matrix);
    }
    
    ArrayList<Integer> results;
    
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        results = new ArrayList<Integer>();
        int height = matrix.length;
        if (height == 0) {
            return results;
        }
        int width = matrix[0].length;
        print(matrix, 0, 0, height, width);
        return results;
    }
    
    void print(int[][] matrix, int startY, int startX, int height, int width) {
        if (height <= 0 || width <= 0) {
            return;
        }
        if (height == 1) {
            for (int i = 0; i < width; i++) {
                results.add(matrix[startY][i + startX]);
            }
        }
        else if (width == 1) {
            for (int i = 0; i < height; i++) {
                results.add(matrix[i + startY][startX]);
            }
        }
        else {
            for (int i = 0; i < width; i++) {
                results.add(matrix[startY][i + startX]);
            }
            for (int i = 1; i < height; i++) {
                results.add(matrix[i + startY][startX + width - 1]);
            }
            for (int i = 1; i < width; i++) {
                results.add(matrix[startY + height - 1][startX + width - 1 - i]);
            }
            for (int i = 1; i < height - 1; i++) {
                results.add(matrix[startY + height - 1 - i][startX]);
            }
            print(matrix, startY + 1, startX + 1, height - 2, width - 2);
        }
    }
}
