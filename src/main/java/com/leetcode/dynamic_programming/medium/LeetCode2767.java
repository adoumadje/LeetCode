package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2767 {
    int INF = 20, n;
    String s;
    Integer[] mem;
    List<String> powers;

    public int minimumBeautifulSubstrings(String s) {
        this.s = s;
        this.n = s.length();
        this.mem = new Integer[n];
        this.powers = generatePowers();
        int res = dfs(0);
        return res > n ? -1 : res;
    }

    private List<String> generatePowers() {
        List<String> powers = new ArrayList<>();
        int curr = 1;
        String b;
        while((b = bin(curr)).length() <= n) {
            powers.add(b);
            curr *= 5;
        }
        return powers;
    }

    private String bin(int curr) {
        StringBuilder sb = new StringBuilder();
        boolean started = false;
        for(int i = 30; i >= 0; --i) {
            if(started) {
                char ch = (curr & (1<<i)) != 0 ? '1' : '0';
                sb.append(ch);
            } else if ((curr & (1<<i)) != 0) {
                started = true;
                sb.append('1');
            }
        }
        return sb.toString();
    }

    private int dfs(int start) {
        if(start >= n) return 0;
        if(mem[start] != null) return mem[start];
        int res = INF;
        for(String pow: powers) {
            if(s.startsWith(pow, start))
                res = Math.min(res, 1 + dfs(start + pow.length()));
        }
        return mem[start] = res;
    }
}
