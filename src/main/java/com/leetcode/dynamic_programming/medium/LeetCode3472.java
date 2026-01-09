package com.leetcode.dynamic_programming.medium;

public class LeetCode3472 {
    Integer[][][] mem;
    char[] sa;
    char a = 'a';
    int n;
    int T = 26;

    public int longestPalindromicSubsequence(String s, int k) {
        this.n = s.length();
        this.sa = s.toCharArray();
        this.mem = new Integer[n][n][k+1];
        int res = 0;
        for(int i = 0; i < n; ++i) {
            int curr = Math.max(dfs(i, i+1, k), 1 + dfs(i-1, i+1, k));
            res = Math.max(res, curr);
        }
        return res;
    }

    private int dfs(int i, int j, int k) {
        if(i < 0 || j >= n) return 0;
        if(mem[i][j][k] != null) return mem[i][j][k];
        int x = Math.min(sa[i]-a, sa[j]-a);
        int y = Math.max(sa[i]-a, sa[j]-a);
        int cost = Math.min(y - x, T+x - y);
        int pay = 0;
        if(cost <= k) {
            pay = 2 + dfs(i-1, j+1, k-cost);
        }
        int left = dfs(i-1, j, k);
        int right = dfs(i, j+1, k);
        int both = dfs(i-1, j+1, k);
        return mem[i][j][k] = Math.max(Math.max(pay, both), Math.max(left, right));
    }
}
