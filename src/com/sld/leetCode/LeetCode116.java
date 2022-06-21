package com.sld.leetCode;

/**
 * 填写每一个节点的下一个右侧节点指针
 * 错误思路：root的左孩子连接右孩子，root的左孩子的右孩子连接root的右孩子的左孩子
 * 这样的话孩子的孩子、孩子的孩子的孩子。。。也需要进行处理
 * @Author: shaold
 * @since 2021-2-24 11:18
 */
public class LeetCode116 {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    // 定义：输入两个节点，将它俩连接起来
    private void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
