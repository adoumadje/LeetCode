package com.leetcode.sliding.window.easy;

public class LeetCode3258 {
    public int countKConstraintSubstrings(String s, int k) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int zeros = 0, ones = 0;
        int l = 0, count = 0;
        for(int r = 0; r < n; ++r) {
            if(sa[r] == '0') {
                zeros += 1;
            } else {
                ones += 1;
            }
            while (zeros > k && ones > k) {
                if(sa[l] == '0') {
                    zeros -= 1;
                } else {
                    ones -= 1;
                }
                l += 1;
            }
            count += r-l+1;
        }
        return count;
    }
}
