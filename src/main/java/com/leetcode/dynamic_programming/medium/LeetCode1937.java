package com.leetcode.dynamic_programming.medium;

public class LeetCode1937 {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        int res = equalize(points[0]);
        for(int r = 1; r < m; ++r) {
            for(int c = 0; c < n; ++c) {
                points[r][c] += points[r-1][c];
            }
            res = Math.max(res, equalize(points[r]));
        }
        return res;
    }

    private int equalize(int[] line) {
        int n = line.length;
        int max = line[0];
        for(int i = 1; i < n; ++i) {
            line[i] = Math.max(line[i], line[i-1] - 1);
            max = Math.max(max, line[i]);
        }
        for(int i = n-2; i >= 0; --i) {
            line[i] = Math.max(line[i], line[i+1] - 1);
            max = Math.max(max, line[i]);
        }
        return max;
    }
}
