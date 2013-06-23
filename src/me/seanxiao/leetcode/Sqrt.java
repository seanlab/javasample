package me.seanxiao.leetcode;

public class Sqrt {

    public int sqrt(int x) {
        long last = 0;
        long i;
        for (i = 1; i * i < x; i *= 2) {
            last = i;
        }
        if (i * i == x) {
            return (int)i;
        }
        long m = (i - last) / 2 + last;
        while (m * m != x) {
            if (m * m < x & (m + 1) * (m + 1) > x) {
                return (int)m;
            }
            if (m * m > x) {
                i = m;
                m = (i - last) / 2 + last;
            }
            else {
                last = m;
                m = (i - last) / 2 + last;
            }
        }
        return (int)m;
    }
}
