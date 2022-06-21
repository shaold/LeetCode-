package com.sld.leetCode;

/**
 * 买股票类型题目
 * @Author: shaold
 * @since 2021-2-7 11:28
 */
public class LeetCode122 {
    /**
     * 方法一 因为是无限次买入，直接计算增长的和
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i-1] < prices[i]){
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    /**
     * 方法二 套用股票算法的模板
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        // dp[i][0] 表示第 ii 天交易完后手里没有股票的最大利润
        // dp[i][1] 表示第 ii 天交易完后手里持有股票的最大利润
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[n-1][0];
    }
}
