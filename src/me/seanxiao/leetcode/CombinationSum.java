package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        Arrays.sort(candidates);
        solution(results, current, target, candidates, candidates.length - 1);
        return results;
    }
    
    public void solution(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> current, int remain, int[] candidates, int startIndex) {
        if (remain == 0) {
            results.add(current);
        }
        else if (remain < 0) {
            return;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (remain >= candidates[i]) {
                int value = remain - candidates[i];
                ArrayList<Integer> newCurrent = new ArrayList<Integer>(current);
                newCurrent.add(0, candidates[i]);
                solution(results, newCurrent, value, candidates, i);
            }
        }
    }
    
    public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
        int[] array = {2};
        obj.combinationSum(array, 1);
    }
}
