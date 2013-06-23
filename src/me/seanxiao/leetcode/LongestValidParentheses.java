package me.seanxiao.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses obj = new LongestValidParentheses();
        obj.longestValidParentheses("()(())");
    }
    
    public int longestValidParentheses(String s) {
        char[] c = s.toCharArray();
        Stack<Integer> store = new Stack<Integer>();
        int[] right = new int[c.length];
        
        int res=0;
        for(int i=0;i<c.length;i++){
            if(c[i]=='('){
                store.push(i);
            }else{
                if(!store.isEmpty()){
                    right[i]=store.pop() + 1;
                    int temp = right[i] - 2;
                    if(temp>=0 && right[temp] > 0) {
                        right[i]=right[temp];
                    }
                    res=Math.max(i-right[i]+2,res);
                }
            }
        }
        return res;
    }
}
