package me.seanxiao.programmingpearl;

public class BitOperation {


    private final byte[] array;

    public BitOperation(int length) {
        array = new byte[length];
    }

    public void set(int i) {
        array[i] = 1;
    }

    public void clear(int i) {
        array[i] = 0;
    }

    public boolean test(int i) {
        return array[i] == 1 ;
    }
}
