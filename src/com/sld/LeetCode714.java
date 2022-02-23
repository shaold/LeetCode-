package com.sld;

/**
 * 股票 带手续费
 * @Author: shaold
 * @since 2021-2-7 21:26
 */
public class LeetCode714 {
    public static void main(String[] args) {
        LeetCode714 leetCode714 = new LeetCode714();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int i = leetCode714.maxProfit(prices, 2);
        System.out.println(i);

    }
    public int maxProfit(int[] prices, int fee) {
        int dp_i_0 = 0;
        // 注意，这里不是-prices[0]
        int dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, temp - price - fee);
        }
        return dp_i_0;
    }
}
