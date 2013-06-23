package me.seanxiao.leetcode;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = 1;
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
            }
            array = temp;
        }
        return array[m - 1];
    }

}
