package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    int num;
    
    ArrayList<String> results;
    
    public ArrayList<String> generateParenthesis(int n) {
        results = new ArrayList<String>();
        num = n;
        _solution("", 0, 0, 0);
        return results;
    }
    
    public void _solution(String result, int depth, int left, int right) {
        if (depth == num * 2) {
            results.add(result);
            return;
        }
        if (left < num) {
            _solution(result + "(", depth + 1, left + 1, right);
        }
        if (right < left) {
            _solution(result + ")", depth + 1, left, right + 1);
        }
    }
    
    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        List<String> results = obj.generateParenthesis(2);
        for (String string : results) {
            System.out.println(string);
        }
    }
}
