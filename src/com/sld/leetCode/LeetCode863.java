package com.sld.leetCode;



import com.sld.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author: shaold
 * @since 2021-7-28 21:40
 */
public class LeetCode863 {

    List<Integer> result;
    List<Integer> temp;
    int distance = 0;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        result = new ArrayList<>();
        temp = new ArrayList<>();
        if (k == 0){
            result.add(target.val);
            return result;
        }

        dfs(root,target,k);

        return result;
    }

    private void dfs(TreeNode node,TreeNode target, int k){
        if (node == null){
            return;
        }

        if (node == target){
            distance = 0;
        }

        if (distance == k){
            result.add(node.val);
        }

        distance++;

        dfs(node.left,target,k);
        dfs(node.right,target,k);
    }
}
