package com.leetcode.dynamic_programming.medium;

public class LeetCode3489 {
    int[][] qa;
    int n, M;
    int[] nums;

    public int minZeroArray(int[] nums, int[][] queries) {
        this.n = nums.length;
        this.M = queries.length;
        this.qa = new int[n][M];
        this.nums = nums;
        int left, right;

        for(int i = 0; i < M; ++i) {
            int[] query = queries[i];
            left = query[0];
            right = query[1];
            int val = query[2];
            for(int j = left; j <= right; ++j) {
                qa[j][i] = val;
            }
        }

        left = 0;
        right = M;
        int res = -1;
        while(left <= right) {
            int mid = left + (right-left) / 2;
            if(good(mid)) {
                res = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return res;
    }

    private boolean good(int m) {
        for(int i = 0; i < n; ++i) {
            int x = nums[i];
            boolean[] knapsack = new boolean[x+1];
            knapsack[0] = true;
            for(int q = 0; q < m; ++q) {
                for(int v = x; v >= qa[i][q]; --v) {
                    knapsack[v] = knapsack[v] || knapsack[v-qa[i][q]];
                }
            }
            if(!knapsack[x]) return false;
        }
        return true;
    }
}
