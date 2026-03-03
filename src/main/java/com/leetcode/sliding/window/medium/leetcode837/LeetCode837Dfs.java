package com.leetcode.sliding.window.medium.leetcode837;

public class LeetCode837Dfs {
    int KK, NN, MAX_PTS;
    Double[] mem;

    public double new21Game(int n, int k, int maxPts) {
        KK = k;
        NN = n;
        MAX_PTS = maxPts;
        mem = new Double[k+1];
        return dfs(0);
    }

    private double dfs(int k) {
        if(k >= KK) {
            return k <= NN ? 1.0 : 0.0;
        }
        if(mem[k] != null) return mem[k];
        double prob = 0.0;
        for(int i = 1; i <= MAX_PTS; ++i) {
            prob += dfs(k+i);
        }
        return mem[k] = prob / MAX_PTS;
    }
}
