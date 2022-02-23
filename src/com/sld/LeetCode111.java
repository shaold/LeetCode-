package com.sld;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: shaold
 * @since 2021-2-1 16:24
 */
public class LeetCode111 {

    public static void main(String[] args) {
        TreeNode root = null;
        LeetCode111 leetCode111 = new LeetCode111();
        System.out.println(leetCode111.minDepth(root));

    }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null){
                    return depth;
                }
                if (cur.left != null){
                    queue.offer(cur.left);
                }
                if (cur.right != null){
                    queue.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    class TreeNode {
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


