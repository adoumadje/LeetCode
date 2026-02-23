package com.leetcode.sliding.window.medium;

public class LeetCode567 {
    public boolean checkInclusion(String s1, String s2) {
        char[] sa = s2.toCharArray();
        int n = sa.length, m = s1.length(), M = 26;
        int[] base = new int[M], freq = new int[M];
        char a = 'a';
        for(char x: s1.toCharArray()) base[x-a] += 1;
        int l = 0;
        for(int r = 0; r < n; ++r) {
            freq[sa[r]-a] += 1;
            if(r-l+1 < m) {
                continue;
            } else if (r-l+1 > m) {
                freq[sa[l++]-a] -= 1;
            }
            if(equalArrays(base, freq)) return true;
        }
        return false;
    }

    private boolean equalArrays(int[] base, int[] freq) {
        for(int i = 0; i < base.length; ++i) {
            if(base[i] != freq[i]) return false;
        }
        return true;
    }

}
