package com.leetcode.dynamic_programming.medium;

public class LeetCode3366 {
    int k, n;
    int[] nums;
    Integer[][][] mem;

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        this.k = k;
        this.n = nums.length;
        this.nums = nums;
        this.mem = new Integer[n][op1+1][op2+1];
        return dfs(0, op1, op2);
    }

    private int dfs(int i, int op1, int op2) {
        if(i >= n) return 0;
        if(mem[i][op1][op2] != null) return mem[i][op1][op2];
        int div = nums[i] % 2 == 0 ? nums[i] / 2 : nums[i] / 2 + 1;
        int subk = nums[i] - k;
        int divk = subk % 2 == 0? subk / 2 : subk / 2 + 1;
        int res = nums[i] + dfs(i+1, op1, op2);
        if(op1 > 0)
            res = Math.min(res, div + dfs(i+1, op1-1, op2));
        if(op2 > 0 && nums[i] >= k)
            res = Math.min(res, subk + dfs(i+1, op1, op2-1));
        if(op1 > 0 && op2 > 0 && div >= k)
            res = Math.min(res, div - k + dfs(i+1, op1-1, op2-1));
        if(op1 > 0 && op2 > 0 && nums[i] >= k)
            res = Math.min(res, divk + dfs(i+1, op1-1, op2-1));
        return mem[i][op1][op2] = res;
    }
}
