package com.leetcode.dynamic_programming.medium;

public class LeetCode1653 {
    public int minimumDeletions(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int[] ar = new int[n];
        for(int i = n-2; i >= 0; --i) {
            ar[i] = sa[i+1] == 'a' ? 1 + ar[i+1] : ar[i+1];
        }
        int res = n;
        int bl = 0;
        for(int i = 0; i < n; ++i) {
            res = Math.min(res, bl + ar[i]);
            if(sa[i] == 'b') ++bl;
        }
        return res;
    }
}
