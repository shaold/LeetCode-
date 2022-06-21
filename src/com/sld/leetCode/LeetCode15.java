package com.sld.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum问题
 * @Author: shaold
 * @since 2021-2-20 20:35
 */
public class LeetCode15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        LeetCode15 leetCode15 = new LeetCode15();
        leetCode15.threeSum(nums);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = threeSumTarget(nums, 0);
        System.out.println(lists);
        return lists;
    }

    /* 从 nums[start] 开始，计算有序数组
     * nums 中所有和为 target 的二元组 */
    List<List<Integer>> twoSumTarget(
            int[] nums, int start, int target) {
        // 左指针改为从 start 开始，其他不变
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) {lo++;}
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {hi--;}
            } else {
                res.add(new ArrayList<>(Arrays.asList(left,right)));
                while (lo < hi && nums[lo] == left) {lo++;}
                while (lo < hi && nums[hi] == right) {hi--;}
            }
        }
        return res;
    }

    /**
     * 计算数组 nums 中所有和为 target 的三元组
     * @param nums 数组
     * @param target 目标和
     * @return int[][]
     */
    List<List<Integer>> threeSumTarget(int[] nums, int target) {
        // 数组得排个序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 threeSum 的第一个数
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 twoSum
            List<List<Integer>>
                    tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) {i++;}
        }
        return res;
    }

}
