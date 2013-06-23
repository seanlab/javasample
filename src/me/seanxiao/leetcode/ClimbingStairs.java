package me.seanxiao.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs obj = new ClimbingStairs();
        System.out.println(obj.climbStairs(2));
    }
    
    int[] steps;
    public int climbStairs(int n) {
        if (n == 0) return 0;
        steps = new int[n];
        getStep(0, n);
        return steps[0];
    }
    
    public int getStep(int now, int max) {
        if (now == max) {
            return 1;
        }
        else if (now > max - 1) {
            return 0;
        }
        
        if (steps[now] != 0) {
            return steps[now];
        }
        else {
            int result = getStep(now + 1, max) + getStep(now + 2, max);
            steps[now] = result;
            return result;
        }
    }
}
