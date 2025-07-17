package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode823 {
    int MOD = (int)1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        Map<Integer, Integer> index = new HashMap<>();
        long[] counter = new long[n];
        for(int i = 0; i < n; ++i) {
            index.put(arr[i], i);
        }
        Arrays.fill(counter, 1);
        for(int i = 0; i < n; ++i) {
            for(int j = i-1; j >= 0; --j) {
                if(arr[i] % arr[j] == 0 && index.containsKey(arr[i] / arr[j])) {
                    int k = index.get(arr[i] / arr[j]);
                    counter[i] += counter[j] * counter[k];
                }
            }
        }

        long sum = Arrays.stream(counter).sum() % MOD;
        return (int)sum;
    }
}
