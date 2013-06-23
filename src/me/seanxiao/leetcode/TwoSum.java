package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, ArrayList<Integer>> index = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i< numbers.length; i++) {
            if (!index.containsKey(numbers[i])) {
                index.put(numbers[i], new ArrayList<Integer>());
            }
            index.get(numbers[i]).add(i);
        }
        for (int i = 0; i< numbers.length; i++) {
            int diff = target - numbers[i];
            if (index.containsKey(diff)) {
                ArrayList<Integer> indexs = index.get(diff);
                for (int j = 0; j < indexs.size(); j++) {
                    int index2 = indexs.get(j);
                    if (index2 != i) {
                        int array[] = new int[2];
                        array[0] = i + 1;
                        array[1] = index2 + 1;
                        Arrays.sort(array);
                        return array;
                    }
                }
            }
        }
        return new int[0];
    }
}
