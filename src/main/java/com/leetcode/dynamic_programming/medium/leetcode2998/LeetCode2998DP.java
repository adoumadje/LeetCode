package com.leetcode.dynamic_programming.medium.leetcode2998;

public class LeetCode2998DP {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if(x <= y) return y-x;
        int five = 1 + Math.min(x%5 + minimumOperationsToMakeEqual(x/5, y),
                5 - x%5 + minimumOperationsToMakeEqual(x/5 + 1, y));
        int eleven = 1 + Math.min(x%11 + minimumOperationsToMakeEqual(x/11,y),
                11 - x%11 + minimumOperationsToMakeEqual(x/11 + 1, y));
        return Math.min(x-y, Math.min(five, eleven));
    }
}
