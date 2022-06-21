package com.sld.leetCode;

/**
 * 等差数列划分
 *
 * 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 *
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 *
 * 子数组 是数组中的一个连续序列。 注：注意这里是连续序列！所以不需要排序，可以用动态规划
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author: shaold
 * @since 2021-8-10 10:40
 */
public class LeetCode413 {
    public static void main(String[] args) {
        LeetCode413 leetCode413 = new LeetCode413();
        int[] nums = {2,1,3,4,2,3};
        int i = leetCode413.numberOfArithmeticSlices(nums);
        System.out.println(i);
    }

    /**
     * 暴力解法 O(n^2)
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        if (nums.length < 3){
            return 0;
        }

        for (int i = 0; i < nums.length-2; i++) {
            int a = nums[i];
            int b = nums[i+1];
            int cha = b - a;
            int temp = b;
            int j = i+2;
            while (j<nums.length){
                temp = temp + cha;
                if (nums[j] == temp){
                    ans++;
                    j++;
                }else {
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * 方法二 时间复杂度O(n)
     * @param nums
     * @return
     */
    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        // t[i]为num[i] 和 num[i-1]作为等差数列最后两位时，存在的符合等差数列条件的数组个数
        // 如果num[i+1] - num[i] 的差和 num[i] - num[i-1]相同，说明num[i+1]和num[i]作为等差数列最后两位时的t[i+1]为t[i]+1
        // 如果不相同，t[i+1]置0
        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}
