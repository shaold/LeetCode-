package com.sld;

import java.util.Arrays;

/**
 * @Author: shaold
 * @since 2021-2-2 17:14
 */
public class LeetCode34 {
    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        int[] nums = {5,6,7,8,9,10};
        int[] ints = leetCode34.searchRange(nums, 7);
        System.out.println(Arrays.toString(ints));
    }
    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums,target);
        int right = searchRight(nums, target);
        if (left > right){
            int[] result = {-1,-1};
            return result;
        } else {
            int[] result = {left,right};
            return result;
        }

    }

    private int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int i = nums[mid];
            if (i == target){
                left = mid + 1;
            }else if (i > target){
                right = mid - 1;
            }else if(i < target){
                left = mid + 1;
            }
        }
        return left-1 ;
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            int i = nums[mid];
            if (i == target){
                right = mid - 1;
            }else if (i > target){
                right = mid - 1;
            }else if(i < target){
                left = mid + 1;
            }
        }
        return right+1;
    }
}
