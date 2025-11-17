package com.leetcode.dynamic_programming.medium.leetcode2707;

public class LeetCode2707Rec {
    char[] sa;
    Integer[] mem;
    String[] dictionary;

    public int minExtraChar(String s, String[] dictionary) {
        sa = s.toCharArray();
        mem = new Integer[sa.length];
        this.dictionary = dictionary;
        return dfs(0);
    }

    private int dfs(int i) {
        if(i >= sa.length) return 0;
        if(mem[i] != null) return mem[i];
        int res = 1 + dfs(i+1);
        for(String w: dictionary) {
            if(w.charAt(0) == sa[i] && canFit(i, w)) {
                res = Math.min(res, dfs(i+w.length()));
            }
        }
        return mem[i] = res;
    }

    private boolean canFit(int i, String w) {
        if(i+w.length() > sa.length) return false;
        for(int j = i; j < i+w.length(); ++j) {
            if(sa[j] != w.charAt(j-i))
                return false;
        }
        return true;
    }
}
