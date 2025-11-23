package com.leetcode.dynamic_programming.medium.leetcode2787;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode2787Rec {
    List<Integer> powers;
    Long[][] mem;
    int x;
    long MOD = (long) (1e9+7);

    public int numberOfWays(int n, int x) {
        this.x = x;
        this.powers = generatePowers(n);
        this.mem = new Long[n+1][powers.size()];
        return (int) dfs(n, 0);
    }

    private List<Integer> generatePowers(int n) {
        List<Integer> powers = new ArrayList<>();
        int i = 1;
        int p;
        while ((p = power(i++, x)) <= n) {
            powers.add(p);
        }
        Collections.reverse(powers);
        return powers;
    }

    private int power(int a, int x) {
        int res = 1;
        while (x > 0) {
            if((x&1) != 0) res *= a;
            a *= a;
            x = x >> 1;
        }
        return res;
    }

    private long dfs(int n, int start) {
        if(n == 0) return 1;
        if(start >= powers.size()) return 0;
        if(mem[n][start] != null) return mem[n][start];
        long res = 0;
        for(int i = start; i < powers.size(); ++i) {
            int p = powers.get(i);
            if(p <= n)
                res = (res + dfs(n-p, i+1) % MOD) % MOD;
        }
        return mem[n][start] = res;
    }
}
