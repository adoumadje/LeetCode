package com.leetcode.dynamic_programming.medium.leetcode2522;

public class LeetCode2522Rec {
    int n, len, k;
    char[] sa;
    Integer[] mem;

    public int minimumPartition(String s, int k) {
        this.sa = s.toCharArray();
        this.n = sa.length;
        this.len = getLen(k);
        this.k = k;
        this.mem = new Integer[n];
        int res = dfs(0);
        return res > n ? -1 : res;
    }

    private int dfs(int start) {
        if(start == n-1) {
            return sa[n-1] - '0' <= k ? 1 : n+1;
        } else if(start >= n) {
            return 0;
        }
        if(mem[start] != null) return mem[start];
        int res = n+1;
        int curr = 0;
        for(int i = start; i < start + len && i < n; ++i) {
            curr = curr * 10 + (sa[i] - '0');
            if(curr <= k) {
                res = Math.min(res, 1 + dfs(i+1));
            }
        }
        return mem[start] = res;
    }

    private int getLen(int x) {
        int l = 0;
        while (x > 0) {
            x /= 10;
            ++l;
        }
        return l;
    }
}
