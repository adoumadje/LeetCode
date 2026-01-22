package com.leetcode.sliding.window.easy;

public class LeetCode1876 {
    public int countGoodSubstrings(String s) {
        char[] sa = s.toCharArray();
        int left = 0, n = sa.length, count = 0;
        if(n < 3) return 0;
        for(int right = 2; right < n; ++right) {
            if(sa[left] != sa[left+1]
                    && sa[left+1] != sa[right]
            && sa[left] != sa[right]) {
                count += 1;
            }
            left += 1;
        }
        return count;
    }
}
