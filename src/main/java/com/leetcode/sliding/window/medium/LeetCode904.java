package com.leetcode.sliding.window.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> type = new HashMap<>();
        int l = 0, n = fruits.length;
        int res = 0;
        for(int r = 0; r < n; ++r) {
            type.compute(fruits[r], (k,v) -> v == null ?  1: v+1);
            while (type.size() > 2) {
                type.compute(fruits[l], (k, v) -> v-1);
                if(type.get(fruits[l]) == 0) type.remove(fruits[l]);
                l += 1;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
