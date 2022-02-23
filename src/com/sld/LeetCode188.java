package com.sld;

/**
 * @Author: shaold
 * @since 2021-2-7 22:07
 */
public class LeetCode188 {
    public static void main(String[] args) {
        //
        //2 [1,2,4,2,5,7,2,4,9,0] 结果13
        LeetCode188 leetCode188 = new LeetCode188();
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        int i = leetCode188.maxProfit_k_any(2, prices);
        System.out.println(i);
    }
    int maxProfit_k_any(int max_k, int[] prices) {
        int n = prices.length;
        if(n <= 1){
            return 0;
        }
        if (max_k > n / 2){
            max_k = n/2;
        }

        int[][][] dp = new int[n][max_k + 1][2];
        // k表示已经进行了k次交易，把买入股票作为一次交易，所以买入之后k会+1
        for (int k = max_k; k >= 1; k--) {
            dp[0][k][0]=0;
            dp[0][k][1]=-prices[0];
        }
        for (int i = 1; i < n; i++){
            for (int k = max_k; k >= 1; k--) {
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
