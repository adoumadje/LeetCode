package com.leetcode.sliding.window.medium;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int l = 0,  res = 0;
        int[] alphabet = new int[128];
        for(int r = 0; r < n; ++r) {
            alphabet[sa[r]] += 1;
            while (alphabet[sa[r]] > 1) {
                alphabet[sa[l]] -= 1;
                l += 1;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
