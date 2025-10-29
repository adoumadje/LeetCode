package com.leetcode.dynamic_programming.medium;

public class LeetCode2320 {
    public int countHousePlacements(int n) {
        long z = 1, o = 1;
        long MOD = (long) (1e9 + 7);
        for(int i = 2; i <= n; ++ i) {
            long nz = o % MOD + z % MOD;
            long no = z;
            z = nz % MOD;
            o = no % MOD;
        }
        long res = ((z+o) * (z+o)) % MOD;
        return (int) res;
    }
}
