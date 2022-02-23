package com.sld;

/**
 * @Author: shaold
 * @since 2021-2-25 14:53
 */
public class LeetCode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 如果不能平分
        if (sum % 2 != 0){
            return false;
        }
        sum = sum / 2;
        int n = nums.length;
        // dp[i][j]表示遍历了i个参数，这i个参数可以任意选择放不放进背包，true和false表示这i个参数放置的结果能否达到j这个背包数。
        boolean[][] dp = new boolean[n+1][sum+1];
        // 初始状态
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i-1] < 0){
                    // 装不下第i个物品
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
