package com.leetcode.dynamic_programming.medium.leetcode2707;

public class LeetCode2707DP {
    public int minExtraChar(String s, String[] dictionary) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int[] dp = new int[n+1];
        for(int i = n-1; i >= 0; --i) {
            dp[i] = 1 + dp[i+1];
            for(String w: dictionary) {
                if(w.charAt(0) == sa[i] && canFit(sa, w, i)) {
                    dp[i] = Math.min(dp[i], dp[i+w.length()]);
                }
            }
        }
        return dp[0];
    }

    private boolean canFit(char[] sa, String w, int i) {
        int n = sa.length;
        if(i + w.length() > n) return false;
        for(int j = i; j < i+w.length(); ++j) {
            if(sa[j] != w.charAt(j-i))
                return false;
        }
        return true;
    }
}
