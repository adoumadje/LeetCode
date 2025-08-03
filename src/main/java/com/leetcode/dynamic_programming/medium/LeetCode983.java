package com.leetcode.dynamic_programming.medium;

public class LeetCode983 {
    public int mincostTickets(int[] days, int[] costs) {
        int n = 365;
        Integer[] travel = new Integer[n+1];
        for(int d: days) travel[d] = Integer.MAX_VALUE;
        travel[0] = 0;
        for(int i = 1; i <= n; ++i) {
            if(travel[i] == null) {
                travel[i] = travel[i-1];
            } else {
                int j  = Math.max(0, i-1);
                travel[i] = Math.min(travel[i], travel[j] + costs[0]);
                j = Math.max(0, i-7);
                travel[i] = Math.min(travel[i], travel[j] + costs[1]);
                j = Math.max(0, i-30);
                travel[i] = Math.min(travel[i], travel[j] + costs[2]);
            }
        }
        return travel[n];
    }
}
