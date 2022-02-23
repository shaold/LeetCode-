package com.sld;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: shaold
 * @since 2021-2-8 20:15
 */
public class LeetCode337 {
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        // 停止递归条件
        if (root == null){
            return 0;
        }
        // 备忘录
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        int do_it = root.val + (root.left == null ? 0:rob(root.left.left)+rob(root.left.right))
                +(root.right == null ? 0:rob(root.right.left)+rob(root.right.right));
        int not_do = rob(root.left) + rob(root.right);
        int res = Math.max(do_it,not_do);
        memo.put(root,res);
        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
