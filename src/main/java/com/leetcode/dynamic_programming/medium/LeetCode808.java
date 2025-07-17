package com.leetcode.dynamic_programming.medium;

public class LeetCode808 {
    int[][] operations = {{100, 0}, {75, 25}, {50, 50}, {25, 75}};
    Double[][] mem;
    public double soupServings(int n) {
        if(n > 5000) return 1.0;
        mem = new Double[n+1][n+1];
        return dfs(n, n);
    }

    public double dfs(int a, int b) {
        if(a <= 0 && b <= 0) {
            return 0.5;
        } else if (a <= 0) {
            return 1.0;
        } else if (b <= 0) {
            return 0.0;
        }

        if(mem[a][b] != null) {
            return mem[a][b];
        }

        double res = 0;
        for(int[] op: operations) {
            res += dfs(a - op[0], b-op[1]);
        }
        return mem[a][b] = res / 4;
    }
}
