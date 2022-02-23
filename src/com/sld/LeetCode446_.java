package com.sld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 等差数列划分 II - 子序列
 *
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 *
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 *
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: shaold
 * @since 2021-8-11 15:03
 */
public class LeetCode446_ {

    public static void main(String[] args) {
        LeetCode446_ leetCode446 = new LeetCode446_();
        int[] nums = {2,4,5,6,10};
        int i = leetCode446.numberOfArithmeticSlices2(nums);
        System.out.println(i);
    }

    /**
     * 暴力解法 O(n^3)
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                int a = nums[i];
                int b = nums[j];
                int cha = b-a;
                int temp = b + cha;
                List<Integer> list = new ArrayList<>();
                list.add(a);
                list.add(b);
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[k] == temp){
                        for (int l = k; l < nums.length; l++) {

                        }
                        list.add(temp);
                        System.out.println(list);
                        ans++;
                        temp+=cha;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 参考答案 动态规划 状态转移方程 hashmap记录公差
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                //以当前i为尾项的数目：
                //cnt+1是由当前j位置确定的间隔为d的上一个尾项数目+1转移过来的
                //而再加上f[i].getOrDefault(d, 0)，是因为要加上其他任何与当前j不同位置，但产生公差依然为d的数目
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }
}
