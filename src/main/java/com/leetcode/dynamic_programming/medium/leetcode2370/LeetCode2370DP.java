package com.leetcode.dynamic_programming.medium.leetcode2370;

public class LeetCode2370DP {
    public int longestIdealString(String s, int k) {
        int[] ascii = new int[128];
        char[] sa = s.toCharArray();
        int n = sa.length, res = 1;
        for(int i = n-1; i >= 0; --i) {
            int curr = 1, ch = sa[i];
            int start = ch - k;
            int end = Math.min(ascii.length-1, ch+k);
            for(int j = start; j <= end; ++j) {
                curr = Math.max(curr, 1 + ascii[j]);
            }
            ascii[ch] = Math.max(ascii[ch], curr);
            res = Math.max(res, ascii[ch]);
        }
        return res;
    }
}
