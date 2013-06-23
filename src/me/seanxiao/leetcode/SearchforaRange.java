package me.seanxiao.leetcode;

public class SearchforaRange {

    public static void main(String[] args) {
        SearchforaRange obj = new SearchforaRange();
        int[] array = {1};
        obj.searchRange(array, 1);
    }
    
    public int[] searchRange(int[] A, int target) {
        int e = A.length - 1;
        int s = 0;
        int[] result = new int[2];
        while (e >= s) {
            int m = (e - s) / 2 + s;
            if (A[m] == target) {
                int end = m;
                for (; end < A.length; end++) {
                    if (A[end] != target) {
                        break;
                    }
                }
                end--;

                int start = m;
                for (; start >= 0; start--) {
                    if (A[start] != target) {
                        break;
                    }
                }
                start++;
                result[0] = start;
                result[1] = end;
                return result;
            }
            else if (A[m] < target) {
                s = m + 1;
            }
            else {
                e = m - 1;
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
}
