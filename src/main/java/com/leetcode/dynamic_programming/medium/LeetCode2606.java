package com.leetcode.dynamic_programming.medium;

public class LeetCode2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        char[] sa = s.toCharArray();
        int n = sa.length, m = 26;
        int[] alph = new int[m];
        for(int i = 0; i < m; ++i) alph[i] = i+1;
        for (int i = 0; i < vals.length; ++i) {
            int ch = chars.charAt(i) - 'a';
            alph[ch] = vals[i];
        }
        int prev = 0, res = 0;
        for(int i = n-1; i >= 0; --i) {
            int ch = sa[i] - 'a';
            int curr = Math.max(alph[ch], alph[ch] + prev);
            res = Math.max(res, curr);
            prev = curr;
        }
        return res;
    }
}
