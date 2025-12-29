package com.leetcode.dynamic_programming.medium;

public class LeetCode3335 {
    int z = 25;
    char a = 'a';
    Long[][] mem;
    long MOD = (long) (1e9+7);

    public int lengthAfterTransformations(String s, int t) {
        this.mem = new Long[26][t+1];
        long res = 0;
        for(char ch: s.toCharArray()) {
            res = (res + dfs(ch, t)) % MOD;
        }
        return (int) res;
    }

    private long dfs(char ch, int t) {
        int i = ch - a;
        int time = z-i+1;
        if(time > t) return 1;
        if(mem[i][t] != null) return mem[i][t];
        long res = (dfs('a', t-time) % MOD + dfs('b', t-time) % MOD) % MOD;
        return mem[i][t] = res;
    }
}
