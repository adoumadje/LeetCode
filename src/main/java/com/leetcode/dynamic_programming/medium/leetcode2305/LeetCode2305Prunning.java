package com.leetcode.dynamic_programming.medium.leetcode2305;

import java.util.Arrays;

public class LeetCode2305Prunning {
    int[] kids, cookies;
    int unfairness = Integer.MAX_VALUE, n;

    public int distributeCookies(int[] cookies, int k) {
        this.n = cookies.length;
        this.kids = new int[k];
        this.cookies = cookies;
        dfs(0);
        return unfairness;
    }

    private void dfs(int cookieIndex) {
        if(cookieIndex == n) {
            int currUnfair = Arrays.stream(kids).max().orElseThrow();
            unfairness = Math.min(unfairness, currUnfair);
        } else {
            for(int k = 0; k < kids.length; ++k) {
                kids[k] += cookies[cookieIndex];
                if(kids[k] < unfairness) dfs(cookieIndex + 1);
                kids[k] -= cookies[cookieIndex];
                if(kids[k] == 0) break;
            }
        }
    }
}
