package com.leetcode.dynamic_programming.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class LeetCode764 {
    class Node {
        int left;
        int rigth;
        int top;
        int bottom;

        public boolean isPlusCandidate() {
            return top > 0 && bottom > 0 && left > 0 && rigth > 0;
        }

        public int getPlusSize() {
            return Math.min(top, Math.min(bottom, Math.min(left, rigth)));
        }

        @Override
        public String toString() {
            return String.format("%d", getPlusSize());
        }
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] maze = new int[n][n];
        for(int[] row: maze) {
            Arrays.fill(row, 1);
        }

        for(int[] mine: mines) {
            maze[mine[0]][mine[1]] = 0;
        }

        Node[][] dp = new Node[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                dp[i][j] = new Node();
            }
        }

        // left
        for(int i = 0; i < n; ++i) {
            dp[i][0].left = maze[i][0];
            for(int j = 1; j < n; ++j) {
                dp[i][j].left = maze[i][j] == 0 ? 0 : 1 + dp[i][j-1].left;
            }
        }

        //right
        for(int i = 0; i < n; ++i) {
            dp[i][n-1].rigth = maze[i][n-1];
            for(int j = n-2; j >= 0; --j) {
                dp[i][j].rigth = maze[i][j] == 0 ? 0 : 1 + dp[i][j+1].rigth;
            }
        }

        // top
        for(int j = 0; j < n; ++j) {
            dp[0][j].top = maze[0][j];
            for(int i = 1; i < n; ++i) {
                dp[i][j].top = maze[i][j] == 0 ? 0 : 1 + dp[i-1][j].top;
            }
        }

        // bottom
        for(int j = 0; j < n; ++j) {
            dp[n-1][j].bottom = maze[n-1][j];
            for(int i = n-2; i >= 0; --i) {
                dp[i][j].bottom = maze[i][j] == 0 ? 0 : 1 + dp[i+1][j].bottom;
            }
        }

        return Arrays.stream(dp)
                .flatMap(Arrays::stream)
                .filter(Node::isPlusCandidate)
                .map(Node::getPlusSize)
                .reduce(0, Integer::max);
    }
}
