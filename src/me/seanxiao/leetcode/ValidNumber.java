package me.seanxiao.leetcode;

public class ValidNumber {

    public static void main(String[] args) {
        ValidNumber obj = new ValidNumber();
        System.out.println(obj.isNumber("2e10"));
    }
    
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.trim();
        int status = 0;
        boolean hasNumber = false;
        boolean hasENumber = true;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (status == 0 && cur == ' ') {
                
            }
            else if (status == 0 && (cur == '+' || cur == '-')) {
                status = 2;
            }
            else if ((status == 0 || status == 2) && (cur >= '0' && cur <= '9')) {
                hasNumber = true;
                status = 1;
            }
            else if (status == 1 && cur >= '0' && cur <= '9') {
                hasNumber = true;
            }
            else if ((status == 3 || status == 4) && cur >= '0' && cur <= '9') {
                hasNumber = true;
                status = 4;
            }
            else if ((status == 0 || status == 1 || status == 2) && cur == '.') {
                status = 3;
            }
            else if ((status == 1 || status == 2 || status == 3 || status == 4) && cur == 'e') {
                hasENumber = false;
                status = 5;
            }
            else if (status == 5 && (cur == '+' || cur == '-')) {
                status = 6;
            }
            else if ((status == 5 || status == 6) && cur >= '0' && cur <= '9') {
                hasENumber = true;
                status = 6;
            }
            else {
                return false;
            }
        }
        return (status == 1 || status == 3 || status == 4 || status == 6) && hasNumber && hasENumber;
    }
}
