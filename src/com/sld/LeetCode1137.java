package com.sld;

/**
 * 第 N 个泰波那契数
 *
 * 泰波那契序列 Tn 定义如下： 
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 *
 * @Author: shaold
 * @since 2021-8-8 16:04
 */
public class LeetCode1137 {
    public int tribonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = t0 + t1 + t2;
            int temp = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }
        return ans;
    }
}
