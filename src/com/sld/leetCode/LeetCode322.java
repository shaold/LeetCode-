package com.sld.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: shaold
 * @since 2021-1-20 11:11
 */
public class LeetCode322 {
    public static void main(String[] args) {
        LeetCode322 leetCode322 = new LeetCode322();
        int[] coins = {1,2,5};
        int i = leetCode322.coinChange(coins,11);
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        // 初始化备忘录 x = dp[n] n表示目标钱数
        List<Integer> dp = new ArrayList<>(amount+1);
        for (int i = 0; i < amount+1; i++) {
            dp.add(amount+1);
        }
        // 零元时设置为0
        dp.set(0,0);
        for (int i = 0; i < amount+1; i++) {
            for (int coin : coins) {
                if ((i - coin) < 0) {
                    continue;
                }
                dp.set(i,min(dp.get(i),1+dp.get(i-coin)));
            }
        }
        System.out.println(dp);
        return dp.get(amount);
    }

    public int min(int a, int b){
        return a > b ? b : a;
    }
}
