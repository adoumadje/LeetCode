package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2850 {
    int n, m;
    Integer[][] mem;
    List<int[]> zeros, ones;

    public int minimumMoves(int[][] grid) {
        this.n = 3;
        this.zeros = new ArrayList<>();
        this.ones = new ArrayList<>();
        for(int r = 0; r < n; ++r) {
            for(int c = 0; c < n; ++c) {
                if(grid[r][c] == 0) {
                    zeros.add(new int[]{r, c});
                } else if(grid[r][c] > 1) {
                    while (grid[r][c]-- > 1)
                        ones.add(new int[]{r, c});
                }
            }
        }
        this.m = zeros.size();
        this.mem = new Integer[m][1<<m];
        return dfs(0, 0);
    }

    private int dfs(int p, int mask) {
        if(p == m) return 0;
        if(mem[p][mask] != null) return mem[p][mask];
        int res = Integer.MAX_VALUE;
        int[] one = ones.get(p);
        for(int i = 0; i < m; ++i) {
            if((mask & (1<<i)) == 0) {
                int newMask = mask | (1<<i);
                int[] zero = zeros.get(i);
                int manhattan = Math.abs(one[0] - zero[0])
                        + Math.abs(one[1] - zero[1]);
                res = Math.min(res, manhattan + dfs(p+1, newMask));
            }
        }
        return mem[p][mask] = res;
    }
}
