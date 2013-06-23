package me.seanxiao.leetcode;

import java.util.ArrayList;

public class PascalsTriangle {

    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(1);
        long last = 1;
        for (int i = 1; i <= rowIndex; i++) {
            last = last * (rowIndex + 1 - i) / i;
            result.add((int)last);
        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numRows; i++) {
            result.add(getRow(i));
        }
        return result;
    }
}
