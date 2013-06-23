package me.seanxiao.leetcode;



public class JumpGame {

    int canJump[];
    
    public boolean canJump(int[] A) {
        canJump = new int[A.length];
        return jump(0, A);
    }
    
    public boolean jump(int index, int[] A) {
        
        if (index >= A.length - 1) {
            return true;
        }
        if (canJump[index] != 0) {
            return canJump[index] == 1;
        }
        else {
            int value = A[index];
            boolean result = false;
            while (value > 0) {
                result = result || jump(index + value, A);
                if (result) {
                    break;
                }
                value--;
            }
            canJump[index] = result ? 1 : -1;
            return result;
        }
    }
    
}
