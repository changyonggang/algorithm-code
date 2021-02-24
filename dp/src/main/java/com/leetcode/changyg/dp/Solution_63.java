package com.leetcode.changyg.dp;

public class Solution_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowCount = obstacleGrid.length;
        if (rowCount < 1) {
            return 1;
        }
        int columnCount = obstacleGrid[0].length;
        int [][] dpMap = new int[rowCount][columnCount];
        dpMap[0][0] = 1;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                // 1. 障碍节点
                if (obstacleGrid[i][j] == 1) {
                    dpMap[i][j] = 0;
                    continue;
                }
                // 2. add
                if (i > 0) {
                    dpMap[i][j] = dpMap[i][j] + dpMap[i-1][j];
                }
                if (j > 0) {
                    dpMap[i][j] = dpMap[i][j] + dpMap[i][j-1];
                }
            }
        }

        // debug
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                System.out.print(dpMap[i][j] + "\t");
            }
            System.out.print("\n");
        }

        return dpMap[rowCount-1][columnCount-1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][] { {0,0,0}, {0,1,0}, {0,0,0} };
        int output = new Solution_63().uniquePathsWithObstacles(input);
        System.out.println(output);
    }
}
