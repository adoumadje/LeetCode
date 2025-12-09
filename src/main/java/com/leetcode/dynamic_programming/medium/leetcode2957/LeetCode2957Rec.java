package com.leetcode.dynamic_programming.medium.leetcode2957;

public class LeetCode2957Rec {
    char[] wa;
    int n;
    Integer[] mem;

    public int removeAlmostEqualCharacters(String word) {
        this.wa = word.toCharArray();
        this.n = wa.length;
        this.mem = new Integer[n];
        return dfs(0);
    }

    public int dfs(int i) {
        if(i+1 >= n) return 0;
        if(mem[i] != null) return mem[i];
        int res = 0;
        if(wa[i] == wa[i+1] || Math.abs(wa[i] - wa[i+1] ) == 1) {
            res = 1 + Math.min(dfs(i+1), dfs(i+2));
        } else {
            res = dfs(i+1);
        }
        return mem[i] = res;
    }
}
