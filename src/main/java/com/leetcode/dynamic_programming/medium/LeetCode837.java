package com.leetcode.dynamic_programming.medium;

public class LeetCode837 {
    int ok, n, maxPts;
    Double[] mem;

    public double new21Game(int n, int k, int maxPts) {
        this.ok = k;
        this.n = n;
        this.maxPts = maxPts;
        mem = new Double[k+1];
        return dfs(k);
    }

    private double dfs(int k) {
        if(k <= 0) {
            return ok - k <= n ? 1.0 : 0.0;
        }

        if(mem[k] != null) return mem[k];

        double res = 0.0;
        for(int i = 1; i <= maxPts; ++i) {
            res += dfs(k-i);
        }

        return mem[k] = res / maxPts;
    }
}
