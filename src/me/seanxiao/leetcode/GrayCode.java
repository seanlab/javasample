package me.seanxiao.leetcode;

import java.util.ArrayList;

public class GrayCode {
    
    public static void main(String[] args) {
        GrayCode obj = new GrayCode();
        ArrayList<Integer> results = obj.grayCode(3);
        for (Integer integer : results) {
            System.out.println(integer);
        }
    }
    
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> results = new ArrayList<Integer>();
        solution(0, n, results);
        return results;
    }
    
    public void solution(int now, int n, ArrayList<Integer> result) {
        if (now == 0) {
            result.add(0);
        }
        else {
            int length = result.size();
            int add = (int) Math.pow(2, now - 1);
            for (int i = length - 1; i >= 0; i--) {
                result.add(add + result.get(i));
            }
        }
        if (now == n) {
            return;
        }
        else {
            solution(now + 1, n, result);
        }
    }
}
