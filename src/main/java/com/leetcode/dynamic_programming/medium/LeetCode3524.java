package com.leetcode.dynamic_programming.medium;

public class LeetCode3524 {
    int N, K;
    long[][][] mem;
    int[] nums;

    public long[] resultArray(int[] nums, int k) {
        this.N = nums.length;
        this.K = k;
        for(int i = 0; i < N; ++i) nums[i] %= k;
        this.nums = nums;
        this.mem = new long[N][K][K];
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < k; ++j) {
                mem[i][j] = null;
            }
        }
        long[] res = new long[K];
        for(int i = N-1; i >= 0; --i) {
            long[] curr = dfs(i+1, nums[i]);
            for(int j = 0; j< k; ++j) {
                res[j] += curr[j];
            }
        }
        return res;
    }

    private long[] dfs(int i, int rem) {
        if(i >= N) {
            long[] curr = new long[K];
            curr[rem] = 1;
            return curr;
        }
        if(mem[i][rem] != null) return mem[i][rem];
        long[] further = dfs(i+1, (rem * nums[i]) % K);
        long[] curr = further.clone();
        curr[rem] += 1;
        return mem[i][rem] = curr;
    }
}
