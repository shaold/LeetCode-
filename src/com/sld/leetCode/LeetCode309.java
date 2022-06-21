package com.sld.leetCode;

/**
 * @Author: shaold
 * @since 2021-2-7 21:01
 */
public class LeetCode309 {
    public static void main(String[] args) {
        LeetCode309 leetCode309 = new LeetCode309();
        int[] prices = {2,1,4};
        int i = leetCode309.maxProfit2(prices);
        System.out.println(i);
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //int[][] dp = new int[n][2];
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        // 代表 dp[i-2][0]
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
            //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            //dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp_i_0;
    }

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        // [] [1]的情况
        if(n < 2){
            return 0;
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1){
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                // 注意
                dp[1][1] = Math.max(-prices[1],-prices[0]);
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            if (i > 1){
                dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
            }
        }
        return dp[n-1][0];
    }
}
