package com.leetcode.dynamic_programming.medium.leetcode2745;

public class LeetCode2745Rec {
    Integer[][] mem;

    public int longestString(int x, int y, int z) {
        this.mem = new Integer[4][600000];
        int res = 0;
        res = Math.max(res, 2 + dfs(1, x-1, y, z));
        res = Math.max(res,  2 + dfs(2, x, y-1, z));
        res = Math.max(res, 2 + dfs(3, x, y, z-1));
        return res;
    }

    private int dfs(int prev, int x, int y, int z) {
        int mask = ((x * 100) + y) * 100 + z;
        if(mem[prev][mask] != null) return mem[prev][mask];
        int res = 0;
        if(prev == 1 && y > 0) {
            res = 2 + dfs(2, x, y-1, z);
        } else if (prev == 2 || prev == 3) {
            if(x > 0) res = Math.max(res, 2 + dfs(1, x-1, y, z));
            if(z > 0) res = Math.max(res, 2 + dfs(3, x, y, z-1));
        }
        return mem[prev][mask] = res;
    }
}
