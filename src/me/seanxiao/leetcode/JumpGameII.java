package me.seanxiao.leetcode;

import java.util.ArrayList;

public class JumpGameII {
    public int jump(int[] A) {
        if (A.length == 1) return 0;
        int step = 1;
        boolean[] visited = new boolean[A.length];
        ArrayList<Integer> queue = new ArrayList<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            ArrayList<Integer> newQueue = new ArrayList<Integer>(queue);
            queue.clear();
            while (!newQueue.isEmpty()) {
                int index = newQueue.get(0);
                if (index + A[newQueue.get(0)] >= A.length - 1) {
                    return step;
                }
                for (int i = A[index]; i > 0; i--) {
                    if (index + i < A.length && !visited[index + i]) {
                        visited[index + i] = true;
                        queue.add(index + i);
                    }
                }
                newQueue.remove(0);
            }
            step++;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        JumpGameII obj = new JumpGameII();
        int[] array = {1,2};
        obj.jump(array);
    }
}
