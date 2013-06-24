package me.seanxiao.programmingpearl;

public class Rotate {

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        System.out.println(rotate.rotate("abcde".toCharArray(), 1));
    }

    public String rotate(char[] str, int offset) {
        int actualOffset = offset % str.length;
        switchStr(str, 0, actualOffset - 1);
        switchStr(str, actualOffset, str.length - 1);
        switchStr(str, 0, str.length - 1);
        return new String(str);
    }

    private void switchStr(char[] str, int begin, int end) {
        for (int i = begin; i <= (end - begin) / 2 + begin; i++) {
            char temp = str[i];
            str[i] = str[end - i + begin];
            str[end - i + begin] = temp;
        }
    }
}
