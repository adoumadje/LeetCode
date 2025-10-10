package com.leetcode.dynamic_programming.medium;

public class LeetCode1888 {
    public int minFlips(String s) {
        char[] sa = (s+s).toCharArray();
        int n = sa.length;
        char[][] pa = new char[n][2];
        for(int i = 0; i < n; ++i) {
            pa[i][0] = i % 2 == 0 ? '0' : '1';
            pa[i][1] = i % 2 == 0 ? '1' : '0';
        }
        int zero = 0, one = 0, l = 0;
        int res = n;
        for(int r = 0; r < n; ++r) {
            zero += sa[r] != pa[r][0] ? 1 : 0;
            one += sa[r] != pa[r][1] ? 1 : 0;
            if(r-l+1 > n/2) {
                zero -= sa[l] != pa[l][0] ? 1 : 0;
                one -= sa[l] != pa[l][1] ? 1 : 0;
                ++l;
            }
            if(r-l+1 == n/2)
                res = min(res, zero, one);
        }
        return res;
    }

    public int min(int ...arr) {
        int m = Integer.MAX_VALUE;
        for(int x: arr)
            m = Math.min(m, x);
        return m;
    }
}
