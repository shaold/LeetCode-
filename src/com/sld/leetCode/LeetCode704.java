package com.sld.leetCode;

/**
 * @Author: shaold
 * @since 2021-2-2 17:08
 */
public class LeetCode704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int i = nums[mid];
            if (i == target){
                return mid;
            }else if (i > target){
                right = mid - 1;
            }else if(i < target){
                left = mid + 1;
            }
        }
        return -1;
    }
}
