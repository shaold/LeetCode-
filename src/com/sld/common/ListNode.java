package com.sld.common;

import com.sld.leetCode.LeetCode25;

/**
 * 单链表节点类型
 * @author s-ld
 */
public class ListNode {
    /**
     * 结点存储的值
     */
    public int val;

    /**
     * 指向下一个节点的指针
     */
    public ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
