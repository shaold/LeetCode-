package com.sld;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 * N*N的棋盘，N个皇后，横竖不能重复，列出所有排法
 * @Author: shaold
 * @since 2021-1-27 10:33
 */
public class LeetCode51 {

    List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        LeetCode51 leetCode51 = new LeetCode51();
        List<List<String>> lists = leetCode51.solveNQueens(8);

        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println("====================");
        }
    }
    private List<List<String>> solveNQueens(int n) {
        // 先初始化棋盘
        List<String> lists = initBoard(n);
        backtrack(lists,0);
        return res;
    }

    private List<String> initBoard(int n){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(".");
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new String(s));
        }
        // 每一行代表一层
        return list;
    }

    void backtrack(List<String> board, int row){
        // 返回的条件
        if (row == board.size()){
            res.add(new ArrayList<>(board));
            return;
        }
        // 选择
        int n = board.get(row).length();
        // 遍历
        for (int col = 0; col < n; col++) {
            // 看这一列的前面几行是否有皇后
            if (!isValid(board, row, col)){
                continue;
            }
            // 置Q
            StringBuffer s = new StringBuffer(board.get(row));
            s.setCharAt(col,'Q');
            board.set(row, s.toString());
            backtrack(board, row + 1);
            // 置.
            StringBuffer s1 = new StringBuffer(board.get(row));
            s1.setCharAt(col,'.');
            board.set(row, s1.toString());

        }
    }

    private boolean isValid(List<String> board, int row, int col){
        // 横竖斜都不能放
        int sum = row + col;
        int length = board.get(row).length();
        for (int i = 0; i < row; i++) {
            // 列冲突
            StringBuffer s = new StringBuffer(board.get(i));
            if (s.charAt(col) == 'Q'){
                return false;
            }
        }
        // 左上冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if ("Q".equals(board.get(i).substring(j, j+1))){
                return false;
            }
        }
        // 右上冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < length; i--, j++) {
            if ("Q".equals(board.get(i).substring(j, j+1))){
                return false;
            }
        }

        return true;
    }
}
