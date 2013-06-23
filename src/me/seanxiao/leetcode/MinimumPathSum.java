package me.seanxiao.leetcode;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int height = grid.length;
        if (height == 0) {
            return 0;
        }
        int width = grid[0].length;
        int[] temp = new int[height];
        int last = 0;
        for (int i = 0; i < temp.length; i++) {
            temp[i] = last + grid[i][0];
            last = temp[i];
        }
        for (int i = 1; i < width; i++) {
            int[] temp2 = new int[height];
            for (int j = 0; j < height; j++) {
                if (j == 0) {
                    temp2[j] = temp[j] + grid[j][i];
                }
                else {
                    temp2[j] = Math.min(temp[j] + grid[j][i], temp2[j - 1] + + grid[j][i]);
                }
            }
            temp = temp2;
        }
        return temp[height - 1];
    }
}
