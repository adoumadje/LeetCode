package com.leetcode.dynamic_programming.medium;

public class LeetCode1578 {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int l = 0, total = 0;
        for(int r = 1; r < n; ++r) {
            if(colors.charAt(l) == colors.charAt(r)) {
                if(neededTime[l] < neededTime[r]) {
                    total += neededTime[l];
                    l = r;
                } else {
                    total += neededTime[r];
                }
            } else {
                l = r;
            }
        }
        return total;
    }
}
