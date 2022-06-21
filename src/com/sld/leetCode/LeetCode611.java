package com.sld.leetCode;

import java.util.Arrays;

/**
 * 有效三角形的个数
 *
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * @Author: shaold
 * @since 2021-8-4 10:33
 */
public class LeetCode611 {
    public static void main(String[] args) {
        LeetCode611 leetCode611 = new LeetCode611();
        int[] nums = {2,2,3,4};
        int i = leetCode611.triangleNumber(nums);
        System.out.println(i);
    }

    /**
     * 时间复杂度n^3超时
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        int result = 0;

        for (int i = 0; i < right-2; i++) {
            int a = nums[i];
            for (int j = i+1; j < right - 1; j++) {
                int b = nums[j];
                for (int k = j+1; k < right; k++) {
                    int c = nums[k];
                    if (a+b>c && a+c>b && b+c>a){
                        result++;
                    }
                }
            }
        }

        return result;
    }

    /**
     * 思路：先排序，最后一次遍历改二分
     * 固定最短的两条边，二分查找最后一个小于两边之和的位置。可以求得固定两条边长之和满足条件的结果。枚举结束后，总和就是答案。
     * @param nums
     * @return
     */
    public int triangleNumber2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int left = j + 1, right = n - 1, k = j;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }

    /**
     * 方法三：双指针
     *
     * 首先对数组排序。
     * 固定最长的一条边，运用双指针扫描
     * 如果 nums[l] + nums[r] > nums[i]，同时说明 nums[l + 1] + nums[r] > nums[i], ..., nums[r - 1] + nums[r] > nums[i]，满足的条件的有 r - l 种，r 左移进入下一轮。
     * 如果 nums[l] + nums[r] <= nums[i]，l 右移进入下一轮。
     * 枚举结束后，总和就是答案。
     * 时间复杂度为 O(n^2)O(n
     * 2
     *  )。
     *
     */
}
