package com.holelin.leetcode;

public class Best_time_to_buy_and_sell_stock_121 {
    /**
     * 贪心做法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int price : prices) {
            low = Math.min(low, price);
            result = Math.max(result, price - low);
        }
        return result;
    }
}
