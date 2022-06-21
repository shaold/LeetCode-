package com.sld.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 矩阵中战斗力最弱的 K 行
 *
 * 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 *
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *
 * 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。
 *
 * 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：战斗值*100 + 行号，然后排序，排完序后再对100取余
 * @Author: shaold
 * @since 2021-8-2 10:30
 */
public class LeetCode1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int length = mat.length;
        int length1 = mat[0].length;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int n = 0;
            for (int j = 0; j < length1; j++) {
                if (mat[i][j] == 1){
                    n++;
                }
            }
            list.add(n*100+i);
        }
        list.sort(Integer::compareTo);
        List<Integer> list1 = list.subList(0, k);

        int[] result = new int[k];
        for (int i = 0; i < list1.size(); i++) {
            result[i] = list1.get(i)%100;
        }
        return result;
    }


    /**
     * 法2
     * @param mat
     * @param k
     * @return
     */
    public int[] kWeakestRows2(int[][] mat, int k) {
        int n = mat.length,m=mat[0].length;
        int[][] count = new int[n][2];
        for(int i=0;i<n;i++){
            count[i][1] = i;
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0) break;
                count[i][0]++;
            }
        }
        // 排序
        Arrays.sort(count,(a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = count[i][1];
        }
        return ans;
    }
}
