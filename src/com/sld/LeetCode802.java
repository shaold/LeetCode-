package com.sld;

import java.util.*;

/**
 * 找到最终的安全状态
 *
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 *
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 *
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 *
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 *
 * 注意：广度优先遍历是不行的，需要深度优先遍历来判断是否有环
 * @Author: shaold
 * @since 2021-8-5 10:36
 */
public class LeetCode802 {
    /**
     * 我们可以使用深度优先搜索来找环，并在深度优先搜索时，用三种颜色对节点进行标记，标记的规则如下：
     *
     * 白色（用 0 表示）：该节点尚未被访问；
     * 灰色（用 1 表示）：该节点位于递归栈中，或者在某个环上；
     * 黑色（用 2 表示）：该节点搜索完毕，是一个安全节点。
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (safe(graph, color, i)) {
                ans.add(i);
            }
        }
        return ans;
    }

    /**
     * 递归判断某一个节点是否是安全节点，如果某个节点的所有子节点安全，说明这个节点安全
     * @param graph
     * @param color
     * @param x
     * @return
     */
    public boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) {
            // 深度优先遍历又遇到了这个节点
            return color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            // 如果连接的节点全是安全的，说明这个节点安全
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        // 被遍历过，然后啥也没发生，安全
        color[x] = 2;
        return true;
    }
}
