package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        int count = (int)Math.pow(2, S.length);
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < count; i++) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            int k = i;
            for (int j = 0; j < S.length; j++) {
                if (k % 2 == 1) {
                    result.add(S[j]);
                }
                k = k >> 1;
            }
            results.add(result);
        }
        return results;
    }
}
