package me.seanxiao.leetcode;


public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        int[] num = {1,3,2};
        obj.nextPermutation(num);
    }
    
    public void nextPermutation(int[] num) {
        if (num.length < 2) {
            return;
        }
        else {
            for (int i = num.length - 1; i >= 1; i--) {
                if (num[i - 1] < num[i]) {
                    for (int j = num.length - 1; j >= 0; j--) {
                        if (num[j] > num[i - 1]) {
                            int temp = num[j];
                            num[j] = num[i - 1];
                            num[i - 1] = temp;
                            for (int k = 0; k < (num.length - i) / 2; k++) {
                                temp = num[k + i];
                                num[k + i] = num[num.length - k - 1];
                                num[num.length - k - 1] = temp;
                            }
                            return;
                        }
                    }
                    
                }
            }
            for (int i = 0; i < num.length / 2; i++) {
                int temp = num[i];
                num[i] = num[num.length - 1 - i];
                num[num.length - 1 - i] = temp;
            }
        }
    }
}
