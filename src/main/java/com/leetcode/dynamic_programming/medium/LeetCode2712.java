package com.leetcode.dynamic_programming.medium;

public class LeetCode2712 {
    public long minimumCost(String s) {
        int n = s.length();
        char[][] sa = new char[2][n];
        sa[0] = s.toCharArray();
        for(int i = 0; i < n; ++i) {
            sa[1][i] = sa[0][i] == '0' ? '1' : '0';
        }
        long cost = 0;
        int j = 0;
        for(int i = 1; i < n; ++i) {
            if(sa[j][i] != sa[j][i-1]) {
                if(i < n-i) {
                    cost += i;
                } else {
                    cost += n-i;
                    j = (j+1) % 2;
                }
            }
        }
        return cost;
    }
}
