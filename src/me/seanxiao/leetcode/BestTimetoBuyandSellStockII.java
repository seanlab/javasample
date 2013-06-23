package me.seanxiao.leetcode;

public class BestTimetoBuyandSellStockII {
    
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int last = prices[0];
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - last > 0) {
                total += prices[i] - last;
            }
            last = prices[i];
        }
        return total;
    }
}
