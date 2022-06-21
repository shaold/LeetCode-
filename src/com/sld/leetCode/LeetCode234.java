package com.sld.leetCode;

import com.sld.common.ListNode;

/**
 * @Author: shaold
 * @since 2021-3-18 19:36
 */
public class LeetCode234 {

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null) {return true;}
        boolean res = traverse(right.next);
        // 后序遍历代码
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }


}
