package com.sld.common;

public class TreeNode {
    /**
     * 结点存储的值
     */
    public int val;

    /**
     * 指向左侧子节点的指针
     */
    public TreeNode left;

    /**
     * 指向右侧子节点的指针
     */
    public TreeNode right;

    /**
     * 构造函数
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
