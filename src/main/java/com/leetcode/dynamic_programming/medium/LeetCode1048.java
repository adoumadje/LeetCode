package com.leetcode.dynamic_programming.medium;

import java.util.*;

public class LeetCode1048 {
    Set<String> words;
    HashMap<String, Integer> mem;
    public int longestStrChain(String[] words) {
        this.words = new HashSet<>();
        mem = new HashMap<>();
        this.words.addAll(Arrays.asList(words));
        int res = Integer.MIN_VALUE;
        for(String w: this.words) {
            res = Math.max(res, dfs(w));
        }
        return res;
    }

    private int dfs(String w) {
        if(!words.contains(w)) return 0;
        if(w.length() == 1) return 1;
        if(mem.containsKey(w)) return mem.get(w);
        int res = 0;
        for(int i = 0; i < w.length(); ++i) {
            String left = w.substring(0, i);
            String right = w.substring(i+1);
            res = Math.max(res, 1 + dfs(left + right));
        }
        mem.put(w, res);
        return res;
    }
}
