package com.sld;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树寻路
 *
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 *
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 *
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 *
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：递归找当前结点的父结点并放入队列
 * @Author: shaold
 * @since 2021-7-29 11:20
 */
public class LeetCode1104 {
    LinkedList<Integer> result = new LinkedList<>();

    public static void main(String[] args) {
        LeetCode1104 leetCode1104 = new LeetCode1104();
        List<Integer> integers = leetCode1104.pathInZigZagTree(26);
        System.out.println(integers);
    }

    public List<Integer> pathInZigZagTree(int label) {
        findParent(label);
        return result;
    }

    public void findParent(int label){
        if (label == 1){
            result.addFirst(1);
            return;
        }
        result.addFirst(label);
        // 先看label是在奇数行还是在偶数行，如果是奇数行就是正序
        int parent;
        for (int i = 0; i < 20; i++) {
            if (Math.pow(2,i) <= label && Math.pow(2,i+1) > label){
                // i为当前数字的层数
                if (i%2 == 1){
                    // 奇数，反的,先求出这个位置正的值除以二就行
                    int temp = (int)Math.pow(2,i+1) - 1 - label + (int)Math.pow(2,i);
                    parent = temp/2;
                    findParent(parent);
                }else {
                    // 偶数，正的，父节点反
                    int temp = label/2;
                    // 注意这里是第i-1行
                    parent = (int)Math.pow(2,i) - 1 - temp + (int)Math.pow(2,i-1);
                    findParent(parent);
                }
                break;
            }
        }
    }

}
