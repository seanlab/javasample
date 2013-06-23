package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutationII {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Arrays.sort(num);
        for (int i = 0; i< num.length; i++) {
            result.add(num[i]);
        }
        results.add(result);
        while (nextPermutation(num)) {
            result = new ArrayList<Integer>();
            for (int i = 0; i< num.length; i++) {
                result.add(num[i]);
            }
            results.add(result);
        }
        return results;
    }
    
    public boolean nextPermutation(int[] num) {
        if (num.length < 2) {
            return false;
        }
        else {
            for (int i = num.length - 1; i >= 1; i--) {
                if (num[i - 1] < num[i]) {
                    for (int j = num.length - 1; j >= 0; j--) {
                        if (num[j] > num[i - 1]) {
                            int temp = num[j];
                            num[j] = num[i - 1];
                            num[i - 1] = temp;
                            for (int k = 0; k < (num.length - i) / 2; k++) {
                                temp = num[k + i];
                                num[k + i] = num[num.length - k - 1];
                                num[num.length - k - 1] = temp;
                            }
                            return true;
                        }
                    }
                    
                }
            }
            for (int i = 0; i < num.length / 2; i++) {
                int temp = num[i];
                num[i] = num[num.length - 1 - i];
                num[num.length - 1 - i] = temp;
            }
        }
        return false;
    }
}
