package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class SubsetII {

    public static void main(String[] args) {
    }

    public void subsetsWithDup(int[] num, int k) {
        Arrays.sort(num); //Make sure duplicated value are adjacent.
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>()); //Empty set at beginning.
        int start = 0;
        for(int i = 0; i < num.length; i++) {
            int size = results.size();
            for(int j = start; j < size; j++) {
                ArrayList<Integer> sub = new ArrayList<Integer>(results.get(j));
                sub.add(num[i]);
                if (sub.size() <= k) {
                    //Do not have to add if the size is larger than k
                    results.add(sub);
                }
            }

            if(i < num.length - 1 && num[i + 1] == num[i]) {
                //If meet duplicated value, do not have to start over, just start after the latest size.
                start = size;
            }
            else {
                //Start over from the beginning of the result List.
                start = 0;
            }
        }

        for (ArrayList<Integer> result : results) {
            if (result.size() == k) {
                //Print here.
            }
        }
    }
}
