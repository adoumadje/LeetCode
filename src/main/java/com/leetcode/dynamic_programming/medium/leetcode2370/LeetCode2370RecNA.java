package com.leetcode.dynamic_programming.medium.leetcode2370;

public class LeetCode2370RecNA {
    int n, k;
    Integer[][] mem;
    char[] sa;
    public int longestIdealString(String s, int k) {
        this.n = s.length();
        this.k = k;
        this.sa = s.toCharArray();
        mem = new Integer[128][n];
        int res = 0;
        for(int i = 0; i < n; ++i) {
            res = Math.max(res, 1 + dfs(sa[i], i+1));
        }
        return res;
    }

    private int dfs(char prev, int start) {
        if(start >= n) return 0;
        if(mem[prev][start] != null) return mem[prev][start];
        int res = 0;
        for(int i = start; i < n; ++i) {
            if(Math.abs(prev - sa[i]) <= k) {
                res = Math.max(res, 1 + dfs(sa[i], i+1));
            }
        }
        return mem[prev][start] = res;
    }
}
