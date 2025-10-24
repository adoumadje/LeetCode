package com.leetcode.dynamic_programming.medium.leetcode2140;

public class LeetCode2140Rec {
    int[][] questions;
    Long[] mem;
    int n;
    public long mostPoints(int[][] questions) {
        this.n = questions.length;
        mem = new Long[n];
        this.questions = questions;
        return dfs(0);
    }

    private long dfs(int i) {
        if(i >= n) return 0;
        if(mem[i] != null) return mem[i];
        return Math.max(questions[i][0] + dfs(i + 1 + questions[i][1]),
                dfs(i+1));
    }
}
