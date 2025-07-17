package com.leetcode.dynamic_programming.medium;

public class LeetCode813 {
    int[] sums;
    int n;
    Double[][] mem;
    public double largestSumOfAverages(int[] nums, int k) {
        this.n = nums.length;
        mem = new Double[n][k+1];
        sums = new int[n+1];
        for(int i = 1; i <= n; ++i) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        return dfs(0, k);
    }

    public double dfs(int start, int k) {
        if(start >= n) return 0;
        if(k == 1) {
            return (double) (sums[n] - sums[start]) / (n-start);
        }

        if(mem[start][k] != null) return mem[start][k];

        double res = 0;
        for(int i = start; i < n; ++i) {
            res = Math.max(res, (double) (sums[i+1] - sums[start]) / (i-start+1) + dfs(i+1, k-1));
        }

        return mem[start][k] = res;
    }
}
