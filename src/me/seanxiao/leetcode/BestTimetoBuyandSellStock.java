package me.seanxiao.leetcode;

public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int curres = 0;  
        int curmin = prices[0];  
        for (int i = 1; i < prices.length; i++) {  
            if (curres < prices[i] - curmin) { 
                curres = prices[i] - curmin;
            }
            curmin = (curmin > prices[i] ? prices[i] : curmin);  
        }  
        return curres;
    }
}
