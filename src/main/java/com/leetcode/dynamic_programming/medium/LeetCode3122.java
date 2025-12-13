package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode3122 {
    public int minimumOperations(int[][] grid) {
        int m = grid.length, n = grid[0].length, k = 10;
        int[] prev = new int[k], curr;
        for(int c = n-1; c >= 0; --c) {
            curr = new int[k];
            for (int[] row : grid) {
                curr[row[c]] += 1;
            }
            for(int i = 0; i < k; ++i) {
                curr[i] = m - curr[i];
                int next = n*m;
                for(int j = 0; j < k; ++j) {
                    if(j != i)
                        next = Math.min(next, prev[j]);
                }
                curr[i] += next;
            }
            prev = curr;
        }
        return Arrays.stream(prev).min().orElseThrow();
    }
}
