package com.leetcode.dynamic_programming.medium;

public class LeetCode1937 {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        long[] prev = new long[n], curr;
        long res = 0;
        for(int[] row: points) {
            curr = new long[n];
            for(int i = 0; i < n; ++i) {
                curr[i] = row[i] + prev[i];
            }
            res = Math.max(res, normalize(curr));
            prev = curr;
        }
        return res;
    }

    private long normalize(long[] line) {
        int n = line.length;
        long m = line[0];
        for(int i = 1; i < n; ++i) {
            line[i] = Math.max(line[i], line[i-1] - 1);
            m = Math.max(m, line[i]);
        }
        for(int i = n-2; i >= 0; --i) {
            line[i] = Math.max(line[i], line[i+1] - 1);
            m = Math.max(m, line[i]);
        }
        return m;
    }
}
