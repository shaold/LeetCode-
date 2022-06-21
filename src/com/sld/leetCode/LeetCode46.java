package com.sld.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: shaold
 * @since 2021-1-22 10:42
 */
public class LeetCode46 {

    List<List<Integer>> lists = new LinkedList<>();

    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        int[] nums = {1,2,3};

        List<List<Integer>> permute = leetCode46.permute(nums);
        System.out.println(permute);
    }
    /**
     * 题目：传入一个数字序列，返回全排列
     * 首先有一个track记录走过的路径，然后有一个list来记录可以选择的列表，进行递归遍历，
     * 遍历前把选择加入路径，遍历结束后撤回路径
     * 返回条件是路径中已经包含了所有的传入数字,把这一路径加入结果集中
     */
    public List<List<Integer>> permute(int[] nums) {

        // 记录路径
        List<Integer> track = new LinkedList<>();
        backtrack(track,nums);
        return lists;
    }

    private void backtrack(List<Integer> track, int[] nums){
        /**
         * 变量 path 所指向的列表 在深度优先遍历的过程中只有一份 ，深度优先遍历完成以后，回到了根结点，成为空列表。
         * 在 Java 中，参数传递是 值传递，对象类型变量在传参的过程中，复制的是变量的地址。这些地址被添加到 res 变量，
         * 但实际上指向的是同一块内存地址，因此我们会看到 66 个空的列表对象。解决的方法很简单，在 res.add(path);
         * 这里做一次拷贝即可。
         */
        if (track.size() == nums.length){
            // 这里有拷贝的问题，lists.add(track);是不行的
            lists.add(new ArrayList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)){
                continue;
            }
            track.add(num);
            backtrack(track,nums);
            track.remove(track.size()-1);
        }
    }


}
