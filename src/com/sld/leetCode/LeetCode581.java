package com.sld.leetCode;

import java.util.Arrays;

/**
 * 最短无序连续子数组
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 思路一：原数组进行排序，生成新的数组，和原数组进行比较，时间复杂度O(nlogn)
 *
 * @Author: shaold
 * @since 2021-8-3 9:06
 */
public class LeetCode581 {

    public static void main(String[] args) {
        LeetCode581 leetCode581 = new LeetCode581();
        int[] nums = {1,2,3,3,3};
        int unsortedSubarray = leetCode581.findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

    public int findUnsortedSubarray(int[] nums) {
        // 考虑边界值
        if (nums.length == 1){
            return 0;
        }
        // 先排序一遍，然后和原数组进行比较
        int[] temp = Arrays.copyOf(nums,nums.length);
        Arrays.sort(temp);

        int left = 0;
        int right = nums.length - 1;
        // 如果左右同时加减会导致左边比右边大
        boolean flag = true;
        while (left<=right){
            if (flag){
                if (nums[left] == temp[left]){
                    left++;
                }
            }else {
                if (nums[right] == temp[right]){
                    right--;
                }
            }
            flag = !flag;

            if (nums[left] != temp[left] && nums[right] != temp[right]){
                break;
            }
        }
        System.out.println("left:"+left);
        System.out.println("right"+right);
        return right-left+1;
    }

    /**
     * 法二 分成三块区域A、B、C，A区域满足所有的数都递增且小于后面BC两个区域的数，C满足所有的数都递增且都大于AB两个区域的数
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
