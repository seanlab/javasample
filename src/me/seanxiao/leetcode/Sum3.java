package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sum3 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            if (!nums.containsKey(num[i])) {
                nums.put(num[i], 1);
            }
            else {
                nums.put(num[i], nums.get(num[i]) + 1);
            }
            
        }
        Set<ArrayList<Integer>> maps = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < num.length - 2; i++) {
            for (int j = i + 1; j < num.length - 1; j++) {
                if (nums.containsKey(0 - num[i] - num[j])) {
                    int count = nums.get(0 - num[i] - num[j]);
                    if (num[i] == 0 - num[i] - num[j]) count--;
                    if (num[j] == 0 - num[i] - num[j]) count--;
                    if (count > 0) {
                        ArrayList<Integer> array = new ArrayList<Integer>();
                        array.add(num[i]);
                        array.add(num[j]);
                        array.add(0 - num[i] - num[j]);
                        Collections.sort(array);
                        if (!maps.contains(array)) {
                            result.add(array);
                            maps.add(array);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String [] args) {
        Sum3 obj = new Sum3();
        int[] array = {0,0,0};
        obj.threeSum(array);
    }
}
