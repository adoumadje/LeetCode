package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;

public class LeetCode1049 {
    Integer[] mem;
    int[] stones;
    int n, target;
    public int lastStoneWeightII(int[] stones) {
        this.n = stones.length;
        if(n == 1) return stones[0];
        this.stones = stones;
        int sum = Arrays.stream(stones).sum();
        this.target = sum / 2;
        mem = new Integer[1 << n];
        int filled = target - dfs(target, 0);
        return sum - 2 * filled;
    }

    private int dfs(int target, int mask) {
        if(target <= 0) {
            return target == 0 ? target : Integer.MAX_VALUE;
        }
        if(mem[mask] != null) return mem[mask];
        int res = target;
        for(int i = 0; i < n; ++i) {
            int checksum = mask & (1<<i);
            if(checksum == 0) {
                int newMask = mask | (1<<i);
                res = Math.min(res, dfs(target - stones[i], newMask));
            }
        }
        return mem[mask] = res;
    }
}
