package com.leetcode.dynamic_programming.medium.leetcode3144;

public class LeetCode3144Rec {
    char[] wa;
    Integer[] mem;
    int k = 26, n;

    public int minimumSubstringsInPartition(String s) {
        this.wa = s.toCharArray();
        this.n = wa.length;
        this.mem = new Integer[n];
        return dfs(0);
    }

    private int dfs(int start) {
        if(start >= n) return 0;
        if(mem[start] != null) return mem[start];
        int[] alph = new int[k];
        int res = n;
        for(int i = start; i < n; ++i) {
            int ci = wa[i] - 'a';
            alph[ci] += 1;
            if(valid(alph)) {
                res = Math.min(res,  1 + dfs(i+1));
            }
        }
        return mem[start] = res;
    }

    private boolean valid(int[] alph) {
        int ground = -1;
        for(int x: alph) {
            if(x > 0 && ground == -1) {
                ground = x;
            } else if (x > 0 && x != ground) {
                return false;
            }
        }
        return true;
    }
}
