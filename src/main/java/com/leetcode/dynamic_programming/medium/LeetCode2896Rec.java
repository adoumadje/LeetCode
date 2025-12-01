package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2896Rec {
    List<Integer> diff = new ArrayList<>();
    Integer[] mem;
    int x;

    public int minOperations(String s1, String s2, int x) {
        int n = s1.length();
        this.x = x;
        for(int i = 0; i < n; ++i) {
            if(s1.charAt(i) != s2.charAt(i))
                diff.add(i);
        }
        int m = diff.size();
        if(m % 2 == 1) return -1;
        this.mem = new Integer[m];
        return dfs(m-1) / 2;
    }

    private int dfs(int i) {
        if (i < 0) return 0;
        if(mem[i] != null) return mem[i];
        if(i == 0) return mem[i] = x;
        return mem[i] = Math.min(x + dfs(i-1) ,
                2*(diff.get(i) - diff.get(i-1)) + dfs(i-2));
    }
}
