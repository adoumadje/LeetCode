package com.leetcode.sliding.window.easy;

public class LeetCode3090 {
    public int maximumLengthSubstring(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int l = 0;
        int[] alphabet = new int[26];
        char a = 'a';
        int res = 0;
        for(int r = 0; r < n; ++r) {
            int ch = sa[r] - a;
            alphabet[ch] += 1;
            while (alphabet[ch] > 2) {
                int chl = sa[l] - a;
                alphabet[chl] -= 1;
                l += 1;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
