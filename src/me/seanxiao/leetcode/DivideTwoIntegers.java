package me.seanxiao.leetcode;

public class DivideTwoIntegers {

    public static void main(String[] args) {
        DivideTwoIntegers obj = new DivideTwoIntegers();
        System.out.println(obj.divide(5, 2));
    }
    
    public int divide(int dividend, int divisor) {
        long total = 0;
        long temp = Math.abs((long)dividend);
        if (temp < Math.abs((long)divisor)) { 
            return 0;
        }
        while (true) {
            long result = 1;
            long margin = Math.abs((long)divisor);
            while (temp >= (margin << 1)) {
                margin = margin << 1;
                result = result << 1;
            }
            temp = temp - margin;
            total += result;
            if (result == 1 || result == 0 || temp < Math.abs((long)divisor)) {
                break;
            }
        }
        if ((dividend < 0 && divisor >= 0) || (dividend >= 0 && divisor < 0)) {
            total *= -1;
        }
        return (int)total;
    }
}
