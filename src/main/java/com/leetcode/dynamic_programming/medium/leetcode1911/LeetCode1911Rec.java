package com.leetcode.dynamic_programming.medium.leetcode1911;

public class LeetCode1911Rec {
    Long[][] mem;
    int N;
    int[] nums;
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        mem = new Long[n][2];
        this.N = n;
        this.nums = nums;
        return dfs(0, 0);
    }

    private long dfs(int i, int b) {
        if(i == N) return 0;
        if(mem[i][b] != null) return mem[i][b];
        int dx = b == 0 ? 1 : -1;
        return mem[i][b] = Math.max(dx * nums[i] + dfs(i+1, (b+1) % 2),
                dfs(i+1, b));
    }


}
