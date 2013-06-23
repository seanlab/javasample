package me.seanxiao.leetcode;

import java.util.ArrayList;

public class Combinations {
    
    boolean[] used;
    
    int[] sets;
    
    ArrayList<ArrayList<Integer>> results;
    
    int lastStart = -1;
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        sets = new int[n];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            sets[i] = i + 1;
        }
        results = new ArrayList<ArrayList<Integer>>();
        lastStart = -1;
        solution(n, k, new ArrayList<Integer>());
        return results;
    }
    
    public void solution(int n, int k, ArrayList<Integer> temp) {
        if (temp.size() == k) {
            results.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] == false && i > lastStart) {
                used[i] = true;
                lastStart = i;
                ArrayList<Integer> newTemp = new ArrayList<Integer>(temp);
                newTemp.add(sets[i]);
                solution(n, k, newTemp);
                lastStart = i;
                used[i] = false;
            }
        }
    }
}
