package me.seanxiao.programmingpearl;

public class PrintMatrix {

    public static void main(String[] args) {
        PrintMatrix obj = new PrintMatrix();
        int[][] matrix = { { 1, 3, 6, 10, 14, }, { 2, 5, 9, 13, 17, },
                { 4, 8, 12, 16, 19, }, { 7, 11, 15, 18, 20, } };

        obj.printMatrix(matrix);
    }

    public void printMatrix(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int length = height +  width - 3;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < height && j < width) {
                    System.out.print(matrix[i - j][j] + " ");
                }
            }
        }
    }
}
