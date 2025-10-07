package com.leetcode.dynamic_programming.medium;

public class LeetCode1824 {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length, k = 3;
        int[] prev = {1, 0, 1}, curr;
        int res = n;
        for(int i = 1; i < n; ++i) {
            curr = new int[k];
            if(obstacles[i] != 0) curr[obstacles[i] - 1] = n;
            for(int j = 0; j < k; ++j) {
                if(curr[j] != n) {
                    int p0 = prev[j];
                    int p1 = curr[(j+1)%k] < n ? 1 + prev[(j+1)%k] : n;
                    int p2 = curr[(j+2)%k] < n ? 1 + prev[(j+2)%k] : n;
                    curr[j] = min(n, p0, p1, p2);
                    if(i == n-1) res = Math.min(res, curr[j]);
                }
            }
            prev = curr;
        }
        return res;
    }

    private int min(int ...arr) {
        int m = Integer.MAX_VALUE;
        for (int x: arr) m = Math.min(m, x);
        return m;
    }
}
