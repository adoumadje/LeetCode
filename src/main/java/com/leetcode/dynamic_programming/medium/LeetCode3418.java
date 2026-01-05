package com.leetcode.dynamic_programming.medium;

public class LeetCode3418 {
    int M, N;
    int[][] coins;
    Integer[][][] mem;
    int INF = Integer.MIN_VALUE + (int) 5e7;

    public int maximumAmount(int[][] coins) {
        this.M = coins.length;
        this.N = coins[0].length;
        this.coins = coins;
        this.mem = new Integer[M][N][3];
        return dfs(0, 0, 2);
    }

    private int dfs(int r, int c, int kill) {
        if(r >= M || c >= N) return INF;
        if(r == M-1 && c == N-1)
            return coins[r][c] >= 0 || kill == 0 ? coins[r][c] : 0;
        if(mem[r][c][kill] != null) return mem[r][c][kill];
        int res;
        if(coins[r][c] >= 0) {
            res = coins[r][c] + Math.max(dfs(r+1, c, kill), dfs(r, c+1, kill));
        } else if (kill > 0) {
            int whenKill = Math.max(dfs(r+1, c, kill-1), dfs(r, c+1, kill-1));
            int whenNotKill = coins[r][c] + Math.max(dfs(r+1, c, kill), dfs(r, c+1, kill));
            res = Math.max(whenKill, whenNotKill);
        } else {
            res = coins[r][c] + Math.max(dfs(r+1, c, kill), dfs(r, c+1, kill));
        }
        return mem[r][c][kill] = res;
    }
}
