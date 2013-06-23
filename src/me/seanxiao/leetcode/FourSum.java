package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FourSum {

    ArrayList<ArrayList<Integer>> results;
    
    Map<Integer, ArrayList<Integer>> index;

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        index = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i< num.length; i++) {
            if (!index.containsKey(num[i])) {
                index.put(num[i], new ArrayList<Integer>());
            }
            index.get(num[i]).add(i);
        }
        results = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 3; i++) {
            threeSum(num, 0 - num[i], i);
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                i++;
            }
        }
        return results;
            
    }
    
    public void threeSum(int[] num, int target, int lastLastIndex) {
        for (int i = lastLastIndex + 1; i < num.length - 2; i++) {
            twoSum(num, 0 - num[i], lastLastIndex, i);
            while (i < num.length - 1 && num[i] == num[i + 1]) {
                i++;
            }
        }
    }
    
    public void twoSum(int[] numbers, int target, int lastLastIndex, int lastIndex) {
        for (int i = lastIndex + 1; i< numbers.length; i++) {
            int diff = target - numbers[i];
            if (index.containsKey(diff)) {
                ArrayList<Integer> indexs = index.get(diff);
                int lastIndex2 = -1;
                for (int j = 0; j < indexs.size(); j++) {
                    int index2 = indexs.get(j);
                    if (index2 != i && index2 > lastIndex && i > lastIndex && index2 > i) {
                        if (lastIndex2 == -1 || (lastIndex2 != -1 && numbers[lastIndex2] != numbers[index2])) {
                            ArrayList<Integer> result = new ArrayList<Integer>();
                            result.add(numbers[lastLastIndex]);
                            result.add(numbers[lastIndex]);
                            result.add(numbers[i]);
                            result.add(numbers[index2]);
                            results.add(result);
                            lastIndex2 = index2;
                        }
                    }
                }
            }
            while (i < numbers.length - 1 && numbers[i] == numbers[i + 1]) {
                i++;
            }
        }
    }
}
