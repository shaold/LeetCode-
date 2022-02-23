package com.sld;

/**
 * 股票 两笔交易
 * @Author: shaold
 * @since 2021-2-7 14:07
 */
public class LeetCode123 {
    public static void main(String[] args) {
        LeetCode123 leetCode123 = new LeetCode123();
        int[] prices = {1,2,3,4,5};
        int i = leetCode123.maxProfit(prices);
        System.out.println(i);
    }
    // 解法1
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 不用for循环k，直接遍历，而且只保留上一个状态
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        // 这里i从0开始，所以Integer.MIN_VALUE
        for (int i = 0; i < n; i++) {
            dp_i20 = Math.max(dp_i20, dp_i21 + prices[i]);
            dp_i21 = Math.max(dp_i21, dp_i10 - prices[i]);
            dp_i10 = Math.max(dp_i10, dp_i11 + prices[i]);
            dp_i11 = Math.max(dp_i11, -prices[i]);
        }
        return dp_i20;
    }

    // 解法2
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    /*处理 base case */
                    // todo 这里处理有问题
                    dp[0][0][0] = 0;
                    dp[0][0][1] = Integer.MIN_VALUE;
                    dp[0][1][0] = Integer.MIN_VALUE;
                    dp[0][1][1] = -prices[0];
                    dp[0][2][0] = Integer.MIN_VALUE;
                    dp[0][2][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }
}
