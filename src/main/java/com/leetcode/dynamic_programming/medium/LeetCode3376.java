package com.leetcode.dynamic_programming.medium;

import java.util.List;

public class LeetCode3376 {
    int k, n;
    List<Integer> strength;

    public int findMinimumTime(List<Integer> strength, int k) {
        this.k = k;
        this.n = strength.size();
        this.strength = strength;
        return dfs(0, 0, 1);
    }

    private int dfs(int mask, int energy, int x) {
        if(mask == (1<<n) - 1) return 0;
        energy += x;

        boolean cantBrake = true;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i) {
            int stren = strength.get(i);
            if(stren <= energy && (mask & (1<<i)) == 0) {
                cantBrake = false;
                int newMask = mask | (1<<i);
                res = Math.min(res, 1 + dfs(newMask, 0, x+k));
            }
        }
        return cantBrake ? 1 + dfs(mask, energy, x) : res;
    }
}
