package me.seanxiao.leetcode;

public class ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        for (int i = 0; i < height.length - 1;) {
            boolean match = false;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[i]) {
                    result += height[i] * (j - i);
                    i = j;
                    match = true;
                    break;
                }
            }
            if (!match) {
                result += height[i + 1];
                i++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        ContainerWithMostWater obj = new ContainerWithMostWater();
        int[] array = {1,2,4,3};
        obj.maxArea(array);
    }
}
