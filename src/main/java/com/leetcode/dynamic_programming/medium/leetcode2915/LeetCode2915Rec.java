package com.leetcode.dynamic_programming.medium.leetcode2915;

import java.util.List;

public class LeetCode2915Rec {
    int n, INF;
    Integer[][] mem;
    List<Integer> nums;

    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        this.n = nums.size();
        this.INF = -2 * n;
        this.mem = new Integer[n][target+1];
        this.nums = nums;
        int res = dfs(0, target);
        return res < 0 ? -1 : res;
    }

    private int dfs(int start, int target) {
        if(target == 0) return 0;
        if(target < 0 || start >= n) return INF;
        if(mem[start][target] != null) return mem[start][target];
        int res = INF;
        for(int i = start; i < n; ++i) {
            res = Math.max(res, 1 + dfs(i+1, target-nums.get(i)));
        }
        return mem[start][target] = res;
    }
}
