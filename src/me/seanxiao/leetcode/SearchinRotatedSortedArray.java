package me.seanxiao.leetcode;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {
        SearchinRotatedSortedArray obj = new SearchinRotatedSortedArray();
        int[] array = {5,1,3};
        System.out.println(obj.search(array, 3));
    }
    
    public int search(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int m = (start + end) / 2;
            if (A[m] == target) {
                return m;
            }
            else if (A[m] >= A[start]) {
                if (A[start] <= target && target <= A[m]) {
                    end = m - 1;
                }
                else {
                    start = m + 1;
                }
            }
            else {
                if(A[m] >= target || target >= A[start]) {
                    end = m - 1;
                }
                else {
                    start = m + 1;
                }
            }
        }
        return -1;
    }
}
