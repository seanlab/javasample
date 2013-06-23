package me.seanxiao.leetcode;

public class SortColors {

    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) zeros++;
            if (A[i] == 1) ones++;
            if (A[i] == 2) twos++;
        }
        int index = 0;
        while (zeros-- > 0) {
            A[index++] = 0;
        }
        while (ones-- > 0) {
            A[index++] = 1;
        }
        while (twos-- > 0) {
            A[index++] = 2;
        }
    }
}
