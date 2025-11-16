package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2572 {
    int[] primes = {2,3,5,7,11,13,17,19,23,29};
    int[] freq = new int[31];
    long MOD = (long) (1e9+7);
    List<Integer> set = new ArrayList<>();

    public int squareFreeSubsets(int[] nums) {
        for(int x: nums) {
            freq[x] += 1;
            if(freq[x] == 1 && x != 1) set.add(x);
        }
        long subsets = dfs(0, 0);
        long ones = power(2, freq[1]) - 1;
        long total = (subsets + ones + (ones * subsets ) % MOD) % MOD;
        return (int) total;
    }

    private long power(long a, int b) {
        long res = 1;
        a %= MOD;
        while(b > 0) {
            if((b&1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b = b >> 1;
        }
        return res;
    }

    private long dfs(int mask, int i) {
        if(i == set.size())
            return mask != 0 ? 1 : 0;
        long res = dfs(mask, i+1) % MOD;
        int num = set.get(i);
        int newMask = canMultiply(mask, num);
        if(newMask != 0) {
            res = (res + freq[num] * dfs(newMask, i+1) % MOD) % MOD;
        }
        return res;
    }

    private int canMultiply(int mask, int num) {
        for(int p: primes) {
            if(num % p == 0) {
                if((mask & (1<<p)) != 0) return 0;
                mask |= 1<<p;
                num /= p;
                if(num % p == 0) return 0;
            }
        }
        return mask;
    }
}
