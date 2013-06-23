package me.seanxiao.interview;

import java.util.Scanner;

public class MultiplyExceptSelf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        long[] result = new long[count];
        long total = 1;
        for (int i = 0; i < count; i++) {
            String line = sc.nextLine();
            result[i] = Integer.parseInt(line);
            if (i != count - 1) {
                total = total* result[i];
            }
        }
        for(int i = 0; i < count - 1; i++) {
            System.out.println(total / result[i] * result[count - 1]);
        }
        System.out.println(total);
        sc.close();
    }
}
