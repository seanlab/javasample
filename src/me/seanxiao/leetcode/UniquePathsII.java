package me.seanxiao.leetcode;

public class UniquePathsII {
    public static void main(String[] args) {
        UniquePathsII obj = new UniquePathsII();
        int[][] grid = new int[1][1];
        grid[0][0] = 0;
        obj.uniquePathsWithObstacles(grid);
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] array = new int[m];
        boolean block = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                block = true;
            }
            array[i] = block ? 0 : 1;
        }
        for (int i = 1; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    temp[j] = array[j];
                }
                else {
                    temp[j] = array[j] + temp[j - 1];
                }
                if (obstacleGrid[j][i] == 1) {
                    temp[j] = 0;
                }
            }
            array = temp;
        }
        return array[m - 1];
    }
}
