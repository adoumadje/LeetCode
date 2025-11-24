package com.leetcode.dynamic_programming.medium;

import java.util.List;

public class LeetCode2811 {
    Boolean[][] mem;
    int[] presums;
    List<Integer> nums;
    int m;

    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        this.mem = new Boolean[n][n];
        this.m = m;
        this.nums = nums;
        this.presums = new int[n+1];
        for(int i = 1; i <= n; ++i)
            presums[i] = presums[i-1] + nums.get(i-1);
        return dfs(0, n-1);
    }

    private boolean dfs(int start, int end) {
        if(end - start <= 1) return true;
        if(mem[start][end] != null) return mem[start][end];
        boolean res = false;
        for(int i = start; i < end; ++i) {
            if(valid(start, i) && valid(i+1, end)) {
                res = res || (dfs(start, i) && dfs(i+1, end));
            }
        }
        return mem[start][end] = res;
    }

    private boolean valid(int start, int end) {
        if(start == end) return true;
        return presums[end+1] - presums[start] >= m;
    }
}
