package com.leetcode.dynamic_programming.medium;

import java.util.HashSet;
import java.util.Set;

public class LeetCode898 {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < n; ++i) {
            res.add(arr[i]);
            for(int j = i-1; j >= 0; --j) {
                if((arr[j] | arr[i]) == arr[j]) {
                    break;
                }
                res.add(arr[j] |= arr[i]);
            }
        }
        return res.size();
    }
}
