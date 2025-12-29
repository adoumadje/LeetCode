package com.leetcode.dynamic_programming.medium;

public class LeetCode3316 {
    char[] sa, pa;
    int S, P, INF = Integer.MIN_VALUE;
    boolean[] target;
    Integer[][] mem;

    public int maxRemovals(String source, String pattern, int[] targetIndices) {
        this.sa = source.toCharArray();
        this.pa = pattern.toCharArray();
        this.S = sa.length;
        this.P = pa.length;
        target = new boolean[S];
        mem = new Integer[S][P];
        for(int x: targetIndices) target[x] = true;
        return dfs(0, 0);
    }

    private int dfs(int s, int p) {
        if(s >= S) {
            return p >= P ? 0 : INF;
        }

        if(p >= P) {
            return target[s] ? 1 + dfs(s+1, p) : dfs(s+1,p);
        }

        if(mem[s][p] != null) return mem[s][p];

        int res = INF;
        if(sa[s] != pa[p]) {
            res = target[s] ? 1 + dfs(s+1, p) : dfs(s+1, p);
        } else {
            res = target[s] ? Math.max(1 + dfs(s+1, p), dfs(s+1, p+1))
                    : dfs(s+1, p+1);
        }

        return mem[s][p] = res;
    }
}
