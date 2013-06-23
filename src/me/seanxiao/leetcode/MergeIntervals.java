package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        
        Collections.sort(intervals, new Comparator<Interval>() {

            public int compare(Interval o1, Interval o2) {
                return new Integer(o1.start).compareTo(new Integer(o2.start));
            }
        });
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        int i = 0;
        while (i < intervals.size()) {
            int j = i + 1;
            int end = intervals.get(i).end;
            while (j < intervals.size() && end > intervals.get(j).start) {
                end = Math.max(end, intervals.get(j).end);
                j++;
            }
            result.add(new Interval(intervals.get(i).start, end));
            i = j;
        }
        return result;
    }
}
