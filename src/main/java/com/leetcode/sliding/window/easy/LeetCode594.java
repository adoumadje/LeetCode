package com.leetcode.sliding.window.easy;

import java.util.HashMap;

public class LeetCode594 {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int res = 0;
        for(int x: nums) {
            counter.compute(x, (k, v) -> v == null ? 1 : 1 + v);
            if(counter.containsKey(x-1)) {
                res = Math.max(res, counter.get(x-1) + counter.get(x));
            }
            if(counter.containsKey(x+1)) {
                res = Math.max(res, counter.get(x+1) + counter.get(x));
            }
        }
        return res;
    }
}
