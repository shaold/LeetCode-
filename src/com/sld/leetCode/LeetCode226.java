package com.sld.leetCode;

import com.sld.common.TreeNode;

/**
 * 反转二叉树
 * @Author: shaold
 * @since 2021-2-22 20:14
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
