package me.seanxiao.leetcode;

public class SpiralMatrixII {

    public static void main(String[] args) {
        SpiralMatrixII obj = new SpiralMatrixII();
        int[][] result = obj.generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.err.println(result[i][j]);
            }
        }
    }
    
    public int[][] generateMatrix(int n) {
        int[][] results = new int[n][n];
        int xMove = 1;
        int yMove = 0;
        int currentX = 0;
        int currentY = 0;
        for (int i = 1; i <= n * n; i++) {
            results[currentY][currentX] = i;
            if ((currentX == 0 && xMove == -1) || (currentY == 0 && yMove == -1) || (currentX == n - 1 && xMove == 1) || (currentY == n - 1 && yMove == 1) || results[yMove + currentY][xMove + currentX] != 0) {
                if (xMove == 1 && yMove == 0) {
                    yMove = 1;
                    xMove = 0;
                }
                else if (xMove == 0 && yMove == 1) {
                    xMove = -1;
                    yMove = 0;
                }
                else if (xMove == -1 && yMove == 0) {
                    xMove = 0;
                    yMove = -1;
                }
                else {
                    xMove = 1;
                    yMove = 0;
                }
            }
            currentX += xMove;
            currentY += yMove;
        }
        return results;
    }
}
