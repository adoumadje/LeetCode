package com.leetcode.dynamic_programming.medium.leetcode2770;

public class LeetCode2770Rec {
    int INF = -2000, n, target;
    int[] nums;
    Integer[] mem;

    public int maximumJumps(int[] nums, int target) {
        this.nums = nums;
        this.n = nums.length;
        this.target = target;
        this.mem = new Integer[n];
        int res = dfs(0);
        return res < 0 ? -1 : res;
    }

    private int dfs(int start) {
        if(start == n-1) return 0;
        if(mem[start] != null) return mem[start];
        int res = INF;
        for(int i = start+1; i < n; ++i) {
            if(nums[i] - nums[start] >= -target && nums[i] - nums[start] <= target)
                res = Math.max(res, 1 + dfs(i));
        }
        return mem[start] = res;
    }
}
