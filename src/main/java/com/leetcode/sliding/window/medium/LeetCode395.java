package com.leetcode.sliding.window.medium;

public class LeetCode395 {
    char[] sa;
    char a = 'a';
    int K;

    public int longestSubstring(String s, int k) {
        sa = s.toCharArray();
        K = k;
        return solve(0, s.length()-1);
    }

    private int solve(int start, int end) {
        int[] freq = new int[26];
        for(int i = start; i <= end; ++i) {
            freq[sa[i]-a] += 1;
        }
        for(int i = start; i <= end; ++i) {
            if(freq[sa[i]-a] < K) {
                return Math.max(solve(start, i-1), solve(i+1, end));
            }
        }
        return end-start+1;
    }
}
