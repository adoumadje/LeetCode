package com.leetcode.dynamic_programming.medium;

public class LeetCode {
    int[][] stay, travel;
    int N, K;
    Integer[][] mem;

    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        this.N = n;
        this.K = k;
        this.stay = stayScore;
        this.travel = travelScore;
        this.mem = new Integer[N][K];
        int res = 0;
        for(int i = 0; i < n; ++i) {
            res = Math.max(res, dfs(i, 0));
        }
        return res;
    }

    private int dfs(int curr, int k) {
        if(k >= K) return 0;
        if(mem[curr][k] != null) return mem[curr][k];
        int res = 0;
        for(int dest = 0; dest < N; ++dest) {
            int newRes = dest == curr ? stay[k][curr] : travel[curr][dest];
            res = Math.max(res, newRes + dfs(dest, k+1));
        }
        return mem[curr][k] = res;
    }
}
