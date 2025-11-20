package com.leetcode.dynamic_programming.medium.leetcode2745;

public class LeetCode2745Math {
    public int longestString(int x, int y, int z) {
        int total = 2 * ( 2 * Math.min(x, y) + z);
        if(x-y != 0)
            total += 2;
        return total;
    }
}
