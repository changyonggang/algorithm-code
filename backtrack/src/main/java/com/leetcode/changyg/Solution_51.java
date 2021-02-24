package com.leetcode.changyg;

import java.util.*;

public class Solution_51 {
    // 记录每一列以及两个方向的每条斜线上是否有皇后
    private Set<Integer> columns = new HashSet<Integer>();
    private Set<Integer> diagonals1 = new HashSet<Integer>();
    private Set<Integer> diagonals2 = new HashSet<Integer>();

    private List<List<String>> solutions = new ArrayList<List<String>>();

    private List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(queens, n, 0);

        return solutions;
    }

    // 从左上到右下方向的斜线 符合条件：行下标 - 列下标 为固定值
    // 从左下到右上方向的斜线 符合条件：行下标 + 列下标 为固定值
    private void backtrack(int[] queens, int n, int row) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            // 遍历每一行， i 为行号
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                // 代表 表格中 t[row][i] 可以放置皇后
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(queens, n, row + 1);
                // 不能放置
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    public static void main(String[] args) {
        List<List<String>> ret = new Solution_51().solveNQueens(4);
        for (List<String> row : ret) {
            for (String item : row) {
                System.out.println(item);
            }
            System.out.println("---------");
        }
    }
}
