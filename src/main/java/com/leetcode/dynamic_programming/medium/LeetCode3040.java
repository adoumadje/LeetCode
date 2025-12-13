package com.leetcode.dynamic_programming.medium;

public class LeetCode3040 {
    Integer[][][] mem;
    int[] nums, score;

    public int maxOperations(int[] nums) {
        int n = nums.length;
        this.score = new int[3];
        score[0] = nums[0] + nums[1];
        score[1] = nums[n-2] + nums[n-1];
        score[2] = nums[0] + nums[n-1];
        this.nums = nums;
        this.mem = new Integer[n][n][3];
        return 1 + Math.max(dfs(2,n-1, 0),
                Math.max(dfs(0, n-3, 1), dfs(1, n-2, 2)));
    }

    private int dfs(int i, int j, int si) {
        if(i >= j) return 0;
        if(mem[i][j][si] != null) return mem[i][j][si];
        int res = 0;
        if(nums[i] + nums[i+1] == score[si]) {
            res = 1 + dfs(i+2, j, si);
        }
        if(nums[j-1] + nums[j] == score[si]) {
            res = Math.max(res, 1 + dfs(i, j-2, si));
        }
        if(nums[i] + nums[j] == score[si]) {
            res = Math.max(res, 1 + dfs(i+1, j-1, si));
        }
        return mem[i][j][si] = res;
    }
}
