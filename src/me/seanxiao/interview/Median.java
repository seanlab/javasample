package me.seanxiao.interview;

public class Median {

    public static void main(String[] args) {
        Median median = new Median();
        int[] array = { 3, 1, 2, 5, 10, 4, 12 };
        System.out.println(median.findMedian(array));
    }

    public int findMedian(int[] array) {
        if (array.length % 2 == 1) {
            return findKth(array, 0, array.length - 1, array.length / 2 + 1);
        }
        else {
            int median = (findKth(array, 0, array.length - 1, array.length / 2 - 1) +
                    findKth(array, 0, array.length - 1, array.length / 2)) / 2;
            return median;
        }
    }

    public int findKth(int[] array, int start, int end, int k) {
        if (start == end) {
            return array[start];
        }
        int index = start + (end - start) / 2;
        swap(array, start, index);
        int i = start, j = end + 1;
        while (i < j) {
            i++;
            j--;
            while (array[i] < array[start] && i < end)
                i++;
            while (array[j] > array[start] && j >= start)
                j--;
            if (i < j) {
                swap(array, i, j);
            }
        }
        if (array[start] > array[j] && start < j) swap(array, start, j);
        if (j - start + 1 == k) {
            return array[j];
        }
        else if (j - start + 1 > k) {
            return findKth(array, start, j, k);
        } else {
            return findKth(array, j + 1, end, k - (j - start) - 1);
        }
    }

    private void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
}
