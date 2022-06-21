package com.sld.leetCode;

/**
 * 环形打家劫舍
 * @Author: shaold
 * @since 2021-2-8 17:06
 */
public class LeetCode213 {
    /**
     * 因为是环形所以头和尾不能同时偷，三种情况，只偷头，只偷尾，都不偷，其中都不偷肯定小所以不用考虑
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {return nums[0];}
        return Math.max(dp(nums,0,nums.length-2),dp(nums,1,nums.length-1));
    }

    private int dp(int[] nums,int start,int end){
        int n = nums.length;
        // i+1天 i+2天
        int dp_i_1 = 0, dp_i_2 = 0;
        // 第i天
        int dp_i = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i;
    }
}
