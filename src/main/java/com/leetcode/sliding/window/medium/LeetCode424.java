package com.leetcode.sliding.window.medium;

import java.util.Arrays;

public class LeetCode424 {
    public int characterReplacement(String s, int k) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        char A = 'A';
        int l = 0, res = 0;
        int[] freq = new int[26];
        int majority = 0;
        for(int r = 0; r < n; ++r) {
            freq[sa[r]-A] += 1;
            majority = Math.max(majority, freq[sa[r]-A]);
            while (r-l+1 - majority > k) {
                freq[sa[l++]-A] -= 1;
                majority = Arrays.stream(freq).max().orElseThrow();
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
