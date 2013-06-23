package me.seanxiao.leetcode;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	String result = "";
    	for (int i = num2.length() - 1; i >= 0; i--) {
    		String mulResult = doMultiply(num1, num2.charAt(i) + "");
    		if (!mulResult.equals("0")) {
    			for (int j = 0; j < num2.length() - 1 - i; j++) {
    				mulResult = mulResult + "0";
    			}
    		}
    		result = (mulResult + result);
    	}
    	return result;
    }
    
    public String doMultiply(String num1, String num2) {
    	int total = 0;
    	String result = "";
    	for (int i = num1.length() - 1; i >= 0; i--) {
    		int val = Integer.parseInt(num1.charAt(i) + "") * Integer.parseInt(num2);
    		result = (val + total) % 10 + result;
    		total = (val + total) / 10;
    	}
    	if (total != 0) {
    		result = total + result;
    	}
    	return result;
    }
    
    public String doAdd(String num1, String num2) {
    	int total = 0;
    	String result = "";
    	int i,j;
    	for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--) {
    		int val = Integer.parseInt(num1.charAt(i) + "") + Integer.parseInt(num1.charAt(j) + "");
    		result = (val + total) % 10 + result;
    		total = (val + total) / 10;
    	}
    	if (i == -1) {
    		for (;j >= 0; j--) {
    			int val = Integer.parseInt(num2.charAt(j) + "");
        		result = (val + total) % 10 + result;
        		total = (val + total) / 10;
    		}
    	}
    	else if (j == -1) {
    		for (;i >= 0; i--) {
    			int val = Integer.parseInt(num1.charAt(i) + "");
        		result = (val + total) % 10 + result;
        		total = (val + total) / 10;
    		}
    	}
    	if (total != 0) {
    		result = total + result;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	MultiplyStrings obj = new MultiplyStrings();
    	System.out.println(obj.multiply("9", "99"));
    }
}
