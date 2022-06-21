package com.sld.leetCode;


import com.sld.common.TreeNode;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 *
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 *
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 这个二叉树有子节点的话，必然是一个相等，另一个相等或大于
 * 深度优先遍历，
 * @Author: shaold
 * @since 2021-7-27 10:08
 */
public class LeetCode671 {

    int ans;
    int rootvalue;

    public int findSecondMinimumValue(TreeNode root) {
        ans = -1;
        rootvalue = root.val;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node){
        if (node == null){
            return;
        }

        if (ans != -1 && node.val > ans){
            return;
        }

        if (node.val > rootvalue){
            ans = node.val;
        }

        dfs(node.left);
        dfs(node.right);
    }
}
