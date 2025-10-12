package com.leetcode.dynamic_programming.medium;

public class LeetCode1976 {
    Integer[][] mem;
    int[] nums;
    int n;

    public int minSpaceWastedKResizing(int[] nums, int k) {
        this.n = nums.length;
        this.mem = new Integer[n][k+2];
        this.nums = nums;
        return dfs(0, k+1);
    }

    private int dfs(int start, int k) {
        if(start == nums.length) return 0;
        if(k == 0) return Integer.MAX_VALUE;

        if(mem[start][k] != null) return mem[start][k];

        int res = Integer.MAX_VALUE;
        int optimalSize = 0;
        int arrTotal = 0, currWaste;

        for(int i = start; i < n; ++i) {
            optimalSize = Math.max(optimalSize, nums[i]);
            arrTotal += nums[i];
            int next = dfs(i+1, k-1);
            currWaste = next != Integer.MAX_VALUE ?
                    optimalSize * (i-start+1) - arrTotal + next
                    : Integer.MAX_VALUE;
            res = Math.min(res, currWaste);
        }

        return mem[start][k] = res;
    }

}
