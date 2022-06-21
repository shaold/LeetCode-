package com.sld.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并所有重叠的区间，并返回一个不重叠的区间数组
 * @Author: shaold
 * @since 2021-2-20 11:16
 */
public class LeetCode56 {
    public static void main(String[] args) {
        LeetCode56 leetCode56 = new LeetCode56();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = leetCode56.merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {
        // 先排序，left升序 right降序
        Arrays.sort(intervals, (a,b)->{
            if (a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] intv = intervals[i];
            // 如果相交，合并区间
            if (right <= intv[1] && right >= intv[0]){
                right = intv[1];
            }
            // 如果不想交，区间加入结果
            if (right < intv[0]){
                int[] result = {left,right};
                res.add(result);
                left = intv[0];
                right = intv[1];
            }
        }
        int[] result = {left,right};
        res.add(result);
        int[][] array2 = res.toArray(new int[res.size()][]);
        return array2;
    }
}
