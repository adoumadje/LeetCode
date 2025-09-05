package com.leetcode.dynamic_programming.medium;

public class LeetCode1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int M = ((int) 1e4) * 2;
        Integer[] map = new Integer[2*M+1];
        int res = 1;
        for(int x: arr) {
            int d = x- difference;
            x += M;
            d += M;
            if(map[d] != null) {
                map[x] = Math.max(map[x] == null ? 0 : map[x], 1 + map[d]);
            }
            if(map[x] == null) map[x] = 1;
            res = Math.max(res, map[x]);
        }
        return res;
    }
}
