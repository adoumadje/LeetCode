package com.leetcode.dynamic_programming.medium.leetcode678;

public class LeetCode678Rec {
    char[] sa;
    int n;
    Boolean[][] mem;

    public boolean checkValidString(String s) {
        this.sa = s.toCharArray();
        this.n = s.length();
        this.mem = new Boolean[n][n+1];
        return dfs(0, 0);
    }

    private boolean dfs(int i, int sum) {
        if(i == n) return sum == 0;
        if(sum < 0) return false;
        if(mem[i][sum] != null) return mem[i][sum];
        boolean res = false;
        if(sa[i] == '(') {
             res = dfs(i+1, sum + 1);
        } else if (sa[i] == ')') {
            res = dfs(i+1, sum - 1);
        } else {
           res = dfs(i+1, sum + 1)
           || dfs(i+1, sum) || dfs(i+1, sum - 1);
        }
        return mem[i][sum] = res;
    }
}
