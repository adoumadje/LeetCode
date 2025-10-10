package com.leetcode.dynamic_programming.medium.leetcode1911;

public class LeetCode1911Tab {
    public long maxAlternatingSum(int[] nums) {
        long prevPos = 0, prevNeg = 0;
        long currPos, currNeg;
        for(int x: nums) {
            currPos = Math.max(prevPos, prevNeg + x);
            currNeg = Math.max(prevNeg, prevPos - x);

            prevPos = currPos;
            prevNeg = currNeg;
        }
        return Math.max(prevPos, prevNeg);
    }
}
