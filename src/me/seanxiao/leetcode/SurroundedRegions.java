package me.seanxiao.leetcode;

import java.util.ArrayList;


public class SurroundedRegions {
    
    int height;
    int width;
    
    public void solve(char[][] board) {
        height = board.length;
        if (height == 0) return;
        width = board[0].length;
        boolean[][] checked = new boolean[height][width];
    
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'O' && checked[i][j] == false) {
                    boolean[][] used = new boolean[height][width];
                    if (isSurronded(i, j, used, board, checked)) {
                        for (int m = 0; m < used.length; m++) {
                            for (int n = 0; n < used.length; n++) {
                                if (used[m][n]) {
                                    board[m][n] = 'X';
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    class Coordinate {
        int i;
        int j;
    }
    
    public boolean isSurronded(int i, int j, boolean[][] used, char[][] board, boolean[][] checked) {
        Coordinate c = new Coordinate();
        c.i = i;
        c.j = j;
        ArrayList<Coordinate> queue = new ArrayList<Coordinate>();
        queue.add(c);
        boolean result = true;
        while (!queue.isEmpty()) {
            ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
            for (Coordinate coordinate : queue) {
                used[coordinate.i][coordinate.j] = true;
                checked[coordinate.i][coordinate.j] = true;
                if (coordinate.i == 0 || coordinate.j == 0 || coordinate.i == height - 1 || coordinate.j == width - 1) {
                    result = false;
                }
                else {
                    if (checked[coordinate.i - 1][coordinate.j] != true && board[coordinate.i - 1][coordinate.j] == 'O') {
                        Coordinate newC = new Coordinate();
                        newC.i = i - 1;
                        newC.j = j;
                        checked[coordinate.i - 1][coordinate.j] = true;
                        used[coordinate.i - 1][coordinate.j] = true;
                        temp.add(newC);
                    }
                    if (checked[coordinate.i + 1][coordinate.j] != true && board[coordinate.i + 1][coordinate.j] == 'O') {
                        Coordinate newC = new Coordinate();
                        newC.i = i + 1;
                        newC.j = j;
                        checked[coordinate.i + 1][coordinate.j] = true;
                        used[coordinate.i + 1][coordinate.j] = true;
                        temp.add(newC);
                    }
                    if (checked[coordinate.i][coordinate.j - 1] != true && board[coordinate.i][coordinate.j - 1] == 'O') {
                        Coordinate newC = new Coordinate();
                        newC.i = i;
                        newC.j = j - 1;
                        checked[coordinate.i][coordinate.j - 1] = true;
                        used[coordinate.i][coordinate.j - 1] = true;
                        temp.add(newC);
                    }
                    if (checked[coordinate.i][coordinate.j + 1] != true && board[coordinate.i][coordinate.j + 1] == 'O') {
                        Coordinate newC = new Coordinate();
                        newC.i = i;
                        newC.j = j + 1;
                        checked[coordinate.i][coordinate.j + 1] = true;
                        used[coordinate.i][coordinate.j + 1] = true;
                        temp.add(newC);
                    }
                }
            }
            queue = temp;
        }
        return result;
    }
    
    public static void main(String[] args) {
        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        SurroundedRegions obj = new SurroundedRegions();
        obj.solve(board);
    }
}
