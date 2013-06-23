package me.seanxiao.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsertInterval {

    public static void main(String[] args) {
        
        InsertInterval obj = new InsertInterval();
        
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        Interval interval = new Interval();
        interval.start = 1;
        interval.end = 5;
        intervals.add(interval);
        Interval newOne = new Interval();
        newOne.start = 0;
        newOne.end = 0;
        obj.insert(intervals, newOne);
    }
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return new Integer(o1.start).compareTo(new Integer(o2.start));
            }
        });
        int i = 0;
        ArrayList<Interval> result = new ArrayList<Interval>();
        boolean add = false;
        while (i < intervals.size()) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            int j = i;
            
            if ((end >= newInterval.start && start <= newInterval.start) ||
                (newInterval.end >= start && newInterval.start <= start))  {
                add = true;
                start = Math.min(start, newInterval.start);
                end = newInterval.end;
                while (j < intervals.size() && end >= intervals.get(j).start) {
                    end = Math.max(newInterval.end, intervals.get(j).end);
                    i = j;
                    j++;
                }
            }
            result.add(new Interval(start, end));
            i++;
        }
        if (add == false) {
            for (i = 0; i < result.size(); i++) {
                if (result.get(i).start > newInterval.start) {
                    break;
                }
            }
            result.add(i, newInterval);
        }
        return result;
    }
    
//    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
//        int start = -1;
//        int end = -1;
//        if (intervals.size() == 0) {
//            intervals.add(newInterval);
//            return intervals;
//        }
//        for (int i = 0; i < intervals.size(); i++) {
//            if (intervals.get(i).start <= newInterval.start && newInterval.start <= intervals.get(i).end) {
//                start = i;
//            }
//            if (intervals.get(i).start <= newInterval.end && newInterval.end <= intervals.get(i).end) {
//                end = i;
//            } 
//        }
//        if (start != -1 && end != -1) {
//            Interval insert = new Interval();
//            insert.start = Math.min(intervals.get(start).start, newInterval.start);
//            insert.end = Math.max(intervals.get(end).end, newInterval.end);
//            for (int i = start; i <= end; i++) {
//                intervals.remove(start);
//            }
//            intervals.add(start, insert);
//        }
//        else if (start == -1 && end != -1) {
//            Interval insert = new Interval();
//            insert.start = newInterval.start;
//            insert.end = Math.max(intervals.get(end).end, newInterval.end);
//            for (int i = 0; i <= end; i++) {
//                intervals.remove(0);
//            }
//            intervals.add(0, insert);
//        }
//        else if (start != -1 && end == -1) {
//            int length = intervals.size();
//            Interval insert = new Interval();
//            insert.start = Math.min(intervals.get(start).start, newInterval.start);
//            insert.end = newInterval.end;
//            for (int i = start; i <= length - 1; i++) {
//                intervals.remove(start);
//            }
//            intervals.add(start, insert);
//        }
//        else {
//            if (newInterval.start < intervals.get(0).start && newInterval.end < intervals.get(0).start) {
//                intervals.add(0, newInterval);
//            }
//            else if (newInterval.start > intervals.get(intervals.size() - 1).end && newInterval.end > intervals.get(intervals.size() - 1).end) {
//                intervals.add(intervals.size(), newInterval);
//            }
//            else {
//                intervals = new ArrayList<Interval>();
//                intervals.add(newInterval);
//            }
//        }
//        return intervals;
//    }
}
