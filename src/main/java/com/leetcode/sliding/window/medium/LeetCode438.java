package com.leetcode.sliding.window.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] sa = s.toCharArray();
        int n = sa.length, m = p.length(), M = 26;
        int[] base = new int[M], freq = new int[M];
        int l = 0;
        char a = 'a';
        List<Integer> answer = new ArrayList<>();
        for(char x: p.toCharArray()) base[x-a] += 1;
        for(int r = 0; r < n; ++r) {
            freq[sa[r]-a] += 1;
            if(r-l+1 < m) {
                continue;
            } else if (r-l+1 > m) {
                freq[sa[l++]-a] -= 1;
            }
            if(equalArrays(base, freq)) answer.add(l);
        }
        return answer;
    }

    private boolean equalArrays(int[] base, int[] freq) {
        for(int i = 0; i < base.length; ++i) {
            if(base[i] != freq[i]) return false;
        }
        return true;
    }
}
