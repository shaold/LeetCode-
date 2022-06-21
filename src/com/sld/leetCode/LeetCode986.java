package com.sld.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: shaold
 * @since 2021-2-20 14:25
 */
public class LeetCode986 {
    public static void main(String[] args) {
        LeetCode986 leetCode986 = new LeetCode986();
        //int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
        //int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] firstList = {{3,10}};
        int[][] secondList = {{5,10}};
        int[][] ints = leetCode986.intervalIntersection(firstList, secondList);
        System.out.println(Arrays.deepToString(ints));
    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        // 先合并成一个数组再进行处理
        ArrayList<int[]> temp = new ArrayList<>(Arrays.asList(firstList));
        ArrayList<int[]> temp2 = new ArrayList<>(Arrays.asList(secondList));
        temp.addAll(temp2);
        int[][] intervals = temp.toArray(new int[temp.size()][]);
        Arrays.sort(intervals, (a,b)->{
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] intv = intervals[i];

            if (intv[0] >= left && intv[1] <= right){
                res.add(intv);
                // 如果不加continue会有重复的可能比如[[3,10]] [[5,10]]
                continue;
            }
            // 相交
            if (right <= intv[1] && right >= intv[0]){
                int[] result = {intv[0],right};
                res.add(result);
                left = intv[0];
                right = intv[1];
            }
            if (right < intv[0]){
                left = intv[0];
                right = intv[1];
            }
        }
        int[][] array2 = res.toArray(new int[res.size()][]);
        return array2;
    }

}
