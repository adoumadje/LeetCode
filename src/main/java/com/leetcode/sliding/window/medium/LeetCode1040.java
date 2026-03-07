package com.leetcode.sliding.window.medium;

import java.util.Arrays;

public class LeetCode1040 {
    public int[] numMovesStonesII(int[] stones) {
        int n = stones.length;
        Arrays.sort(stones);
        int maxMove = Math.max(stones[n-1] - stones[1] + 1 - (n-1),
                stones[n-2] - stones[0] + 1 - (n-1));
        int minMove = n, l = 0;
        for (int r = 0; r < n; ++r) {
            while (stones[r] - stones[l] + 1 > n) l += 1;
            int occupied = r-l+1;
            if(occupied == n-1 && stones[r] - stones[l] + 1 == n-1) {
                minMove = Math.min(minMove, 2);
            } else {
                minMove = Math.min(minMove, n-occupied);
            }
        }
        return new int[]{minMove, maxMove};
    }
}
