package me.seanxiao.leetcode;

public class WordSearch {

    int height;
    
    int width;
    
    public boolean exist(char[][] board, String word) {
        height = board.length;
        if (height == 0) {
            return false;
        }
        width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] used = new boolean[height][width];
                    boolean find = search(board, word, i, j, 0, used);
                    if (find) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, String word, int i, int j, int start, boolean[][] used) {
        if (start == word.length()) {
            return true;
        }
        if (i == -1) {
            return false;
        }
        if (i == height) {
            return false;
        }
        if (j == -1) {
            return false;
        }
        if (j == width) {
            return false;
        }
        if (used[i][j] == false) {
            if (board[i][j]== word.charAt(start)) {
                used[i][j] = true;
                boolean up = search(board, word, i - 1, j, start + 1, used);
                if (up == true) {
                    return true;
                }
                boolean down = search(board, word, i + 1, j, start + 1, used);
                if (down == true) {
                    return true;
                }
                boolean left = search(board, word, i, j - 1, start + 1, used);
                if (left == true) {
                    return true;
                }
                boolean right = search(board, word, i, j + 1, start + 1, used);
                if (right == true) {
                    return right;
                }
                return false;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
