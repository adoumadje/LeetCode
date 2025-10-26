package com.leetcode.dynamic_programming.medium.leetcode2305;

public class LeetCode2305RecNA {
    int n;
    int[] bags;
    Integer[][] mem;
    public int distributeCookies(int[] cookies, int k) {
        this.n = cookies.length;
        this.bags = new int[1<<n];
        this.mem = new Integer[1<<n][k+1];
        for(int i = 1; i < (1<<n); ++i) {
            for(int j = 0; j < n; ++j) {
                if(((1<<j) & i) != 0) {
                    bags[i] += cookies[j];
                }
            }
        }
        return dfs(0, 0, k);
    }

    private int dfs(int mask, int max, int k) {
        if(mask == (1<<n) - 1) {
            return k == 0 ? max : Integer.MAX_VALUE;
        }
        if(k == 0) return Integer.MAX_VALUE;
        if(mem[mask][k] != null) return mem[mask][k];
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < (1<<n); ++i) {
            if((mask & i) == 0) {
                int newMask = mask | i;
                int newMax = Math.max(max, bags[i]);
                res = Math.min(res, dfs(newMask, newMax, k-1));
            }
        }
        return mem[mask][k] = res;
    }
}
