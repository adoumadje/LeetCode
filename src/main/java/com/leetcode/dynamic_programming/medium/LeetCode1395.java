package com.leetcode.dynamic_programming.medium;

public class LeetCode1395 {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int res = 0;
        for(int i = 1; i < n-1; ++i) {
            int small = 0, big = 0;
            for(int j = 0; j < n; ++j) {
                if(j < i && rating[j] < rating[i]) {
                    ++small;
                } else if (j > i && rating[j] > rating[i]) {
                    ++big;
                }
            }
            res += small * big;
            res += (i - small) * (n - i - 1 - big);
        }
        return res;
    }
}
