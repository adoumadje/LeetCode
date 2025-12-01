package com.leetcode.dynamic_programming.medium.leetcode2896;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2896DP {
    public int minOperations(String s1, String s2, int x) {
        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < s1.length(); ++i) {
            if(s1.charAt(i) != s2.charAt(i))
                diff.add(i);
        }
        int m = diff.size();
        if(m == 0) return 0;
        if(m % 2 == 1) return -1;
        int[] dp = new int[m+1];
        dp[1] = x;
        for(int i = 2; i <= m; ++i) {
            dp[i] = Math.min(x + dp[i-1],
                    2 * (diff.get(i-1) - diff.get(i-2)) + dp[i-2]);
        }
        return dp[m] / 2;
    }
}
