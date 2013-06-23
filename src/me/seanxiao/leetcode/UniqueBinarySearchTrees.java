package me.seanxiao.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
        maps.put(1, 1);
        maps.put(0, 1);
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += maps.get(i - j - 1) * maps.get(j);
            }
            maps.put(i, count);
        }
        return maps.get(n);
    }
}
