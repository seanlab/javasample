package me.seanxiao.leetcode;

public class BestTimetoBuyandSellStockIII {

    public static void main(String[] args) {
        BestTimetoBuyandSellStockIII obj = new BestTimetoBuyandSellStockIII();
        int[] array = {2,1,2,0,1};
        System.out.println(obj.findMaxProfitFirst(array));
    }
    
    
    public int maxProfit(int[] prices) {
        return findMaxProfitFirst(prices);
    }
    
    public int findMaxProfitFirst(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int curres = 0;
        int start = 0;
        int end = 0;
        int tempStart = 0;
        int curmin = prices[0];
        for (int i = 1; i < prices.length; i++) {  
            if (curres < prices[i] - curmin) { 
                curres = prices[i] - curmin;
                end = i;
                start = tempStart;;
            }
            if (curmin > prices[i]) {
                curmin = prices[i];
                tempStart = i;
            }
        }
        int[] anotherPrice = new int[prices.length - 2];
        int j = 0;
        for (int i = 0; i < anotherPrice.length;) {
            if (j != start && j != end) {
                anotherPrice[i] = prices[j];
                i++;
            }
            j++;
        }
        return curres + findMaxProfitSecond(anotherPrice);
    }
    
    public int findMaxProfitSecond(int[] prices) {
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
