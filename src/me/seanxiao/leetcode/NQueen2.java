package me.seanxiao.leetcode;

public class NQueen2 {
	boolean[][] matrix;
	
	int count;
	
	public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		matrix = new boolean[n][n];
		_solution(0, n);
		return count;
    }
	
	public void _solution(int row, int n) {
		if (row >= n) {
			count++;
			return;
		}
		for (int j = 0; j < n; j++) {
			boolean canPut = canPut(row, j, n);
			if (canPut) {
				matrix[row][j] = true;
				_solution(row + 1, n);
				matrix[row][j] = false;
			}
		}
	}
	
	public boolean canPut(int i, int j, int size) {
		for (int m = i - 1; m >= 0; m--) {
			if (matrix[m][j] == true) return false;
		}
		for (int m = j - 1; m >= 0; m--) {
			if (matrix[i][m] == true) return false;
		}
		for (int m = i - 1, n = j - 1; m >= 0 & n >= 0; m--, n--) {
			if (matrix[m][n] == true) return false;
		}
		for (int m = i - 1, n = j + 1; m >= 0 & n < size; m--, n++) {
			if (matrix[m][n] == true) return false;
		}
		return true;
	}

}
