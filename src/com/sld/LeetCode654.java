package com.sld;

/**
 * @Author: shaold
 * @since 2021-3-18 20:22
 */
public class LeetCode654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return null;
    }

    private TreeNode build(int[] nums, int left, int right){
        // 先获取nums中left和right中数据的最大值及其位置

        TreeNode t = new TreeNode();
        return null;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
