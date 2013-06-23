package me.seanxiao.leetcode;

import java.util.ArrayList;

public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        else {
            int min = triangle.get(0).get(0);
            int[] last = new int[1];
            last[0] = min;
            for (int i = 1; i < triangle.size(); i++) {
                int[] temp = new int[i + 1];
                min = Integer.MAX_VALUE;
                for (int j = 0; j < i+ 1; j++) {
                    if (j == 0) {
                        temp[j] = last[0] + triangle.get(i).get(j);
                    }
                    else if (j == i) {
                        temp[j] = last[i - 1] + triangle.get(i).get(j);
                    }
                    else {
                        temp[j] = Math.min(last[j - 1], last[j]) + triangle.get(i).get(j);
                    }
                    if (temp[j] < min) {
                        min = temp[j];
                    }
                }
                last = temp;
            }
            return min;
        }
    }
    
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> array1 = new ArrayList<Integer>();
        array1.add(-1);
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        array2.add(2);
        array2.add(3);
        ArrayList<Integer> array3 = new ArrayList<Integer>();
        array3.add(1);
        array3.add(-1);
        array3.add(-3);
        input.add(array1);
        input.add(array2);
        input.add(array3);
        System.out.println(triangle.minimumTotal(input));
    }
}
