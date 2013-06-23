package me.seanxiao.leetcode;

import java.util.ArrayList;

public class NQueens {
	
	boolean[][] matrix;
	
	ArrayList<String[]> results;
	
	public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		matrix = new boolean[n][n];
		results = new ArrayList<String[]>();
		_solution(0, n);
		return results;
    }
	
	public void _solution(int row, int n) {
		if (row >= n) {
			String[] result = new String[n]; 
			for (int i = 0; i < n; i++) {
				String line = "";
				for (int j = 0; j < n; j++) {
					if (matrix[i][j]) {
						line += 'Q';
					}
					else {
						line += '.';
					}
				}
				result[i] = line;
			}
			results.add(result);
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
	
	public static void main(String[] args) {
		NQueens obj = new NQueens();
		obj.solveNQueens(8);
	}
}
