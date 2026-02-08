package com.leetcode.dynamic_programming.medium;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3811 {
    Map<Integer, Integer> prefix;
    int[] prevt1,  prevt2,  prev0;
    int N;
    long MOD = (long) 1e9 + 7;
    Long[][][] mem;

    public int alternatingXOR(int[] nums, int target1, int target2) {
        N = nums.length;
        prefix = new HashMap<>();
        prevt1  = new int[N];
        prevt2 = new int[N];
        prev0 = new int[N];

        mem = new Long[N][2][2];

        for(int i = 0; i < N; ++i) {
            prevt1[i] = -1;
            prevt2[i] = -1;
            prev0[i] = -1;
        }

        int xor = 0;
        prefix.put(xor, N);
        for(int i = N-1; i >= 0; --i) {
            int x = nums[i];
            xor ^= x;
            if(prefix.containsKey(xor ^ target1)) {
                prevt1[i] = prefix.get(xor ^ target1);
            }
            if(prefix.containsKey(xor ^ target2)) {
                prevt2[i] = prefix.get(xor ^ target2);
            }
            if(prefix.containsKey(xor)) {
                prev0[i] = prefix.get(xor);
            }
            prefix.put(xor, i);
        }

        return Math.toIntExact(dfs(0, 0, 1));

    }

    private long dfs(int index, int zero, int t1) {
        if(index == N) return 1;
        if(mem[index][zero][t1] != null) return mem[index][zero][t1];
        long total = 0;
        if(t1 == 1) {
            if(prevt1[index] != -1) {
                total = (total + dfs(prevt1[index], 1, 0)%MOD) % MOD;
            }
        } else {
            if(prevt2[index] != -1) {
                total = (total + dfs(prevt2[index], 1, 1)%MOD) % MOD;
            }
        }
        if(zero == 1) {
            if(prev0[index] != -1) {
                total = (total + dfs(prev0[index], 1, t1)%MOD) % MOD;
            }
        }
        return mem[index][zero][t1] = total;
    }
}
