package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3747 {
    long[] num;
    int N;
    Long[][][] mem;

    public long countDistinct(long n) {
        List<Long> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n%10);
            n /= 10;
        }
        this.N = digits.size();
        num = new long[N];
        for(int i = 0; i < N; ++i) {
            num[i] = digits.get(N-1-i);
        }
        this.mem = new Long[N][2][2];
        return dfs(0, 1, 1);
    }

    private long dfs(int index, int zero, int prefix) {
        if(index == N) return zero == 1 ? 0 : 1;
        if(mem[index][zero][prefix] != null) return mem[index][zero][prefix];
        long total = 0;
        if(prefix == 1) {
            if(zero == 1) {
                total += dfs(index+1, 1, 0);
            }
            for(int i = 1; i < num[index]; ++i) {
                total += dfs(index+1, 0, 0);
            }
            if(num[index] != 0) {
                total += dfs(index+1, 0, 1);
            }
        } else {
            if(zero == 1) {
                total += dfs(index+1, 1, 0);
            }
            for(int i = 1; i <= 9; ++i) {
                total += dfs(index+1, 0, 0);
            }
        }
        return mem[index][zero][prefix] = total;
    }
}
