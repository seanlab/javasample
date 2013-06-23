package me.seanxiao.leetcode;

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[] array = new int[word1.length() + 1];
        for (int i = 0; i < word1.length() + 1; i++) {
            array[i] = i;
        }
        
        for (int j = 1; j < word2.length() + 1; j++) {
            int[] temp = new int[word1.length() + 1];
            for (int i = 0; i < word1.length() + 1; i++) {
                if (i == 0) {
                    temp[i] = j;
                }
                else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        temp[i] = array[i - 1];
                    }
                    else {
                        temp[i] = Math.min(Math.min(array[i], array[i - 1]), temp[i - 1]) + 1;
                    }
                }
            }
            array = temp;
        }
        return array[word1.length()];
    }
}
