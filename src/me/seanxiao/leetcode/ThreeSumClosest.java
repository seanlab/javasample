package me.seanxiao.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        
        int minDiff = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum == target) {
                    return sum;
                }
                if (sum > target) {
                    int diff = sum - target;
                    if (diff < minDiff) {
                        minDiff = diff;
                        result = sum;
                    }
                    end--;
                }
                else {
                    int diff = target - sum;
                    if (diff < minDiff) {
                        minDiff = diff;
                        result = sum;
                    }
                    start++;
                }
            }
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                i++;
            }
        }
        return result;
    }
}
