package me.seanxiao.leetcode;

public class nthpermutation {

    public static void solution(int i, int n) {
        int j, k = 0;
        int[] fact = new int[i];
        int[] perm = new int[i];
        fact[k] = 1;
        while (++k < i) {
            fact[k] = fact[k - 1] * k;
        }

        for (k = 0; k < i; k++) {
            perm[k] = n / fact[i - 1 - k];
            n = n % fact[i - 1 - k];
        }

        for (k = i - 1; k > 0; --k)
            for (j = k - 1; j >= 0; --j)
               if (perm[j] <= perm[k])
                  perm[k]++;
        for (k = 0; k < i; ++k)
            System.out.print(perm[k] + 1);
    }

    public static void main(String[] args) {
    }
}
