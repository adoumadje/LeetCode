package com.leetcode.dynamic_programming.medium;

public class LeetCode2746 {
    int n;
    String[] words;
    Integer[][][] mem;

    public int minimizeConcatenatedLength(String[] words) {
        this.n = words.length;
        this.mem = new Integer[n][26][26];
        this.words = words;
        return words[0].length() + dfs(1, words[0].charAt(0),
                words[0].charAt(words[0].length()-1));
    }

    private int dfs(int i, char first, char last) {
        if(i == n) return 0;
        int f = first - 'a', l = last - 'a';
        if(mem[i][f][l] != null) return mem[i][f][l];
        int len = words[i].length();
        char fc = words[i].charAt(0), lc = words[i].charAt(len-1);
        int start = (lc == first ? len - 1 : len) + dfs(i+1, fc, last);
        int end = (fc == last ? len-1 : len)  + dfs(i+1, first, lc);
        return mem[i][f][l] = Math.min(start, end);
    }
}
