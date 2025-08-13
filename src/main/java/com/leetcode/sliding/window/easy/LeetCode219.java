package com.leetcode.sliding.window.easy;

import java.util.HashMap;

public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) return false;
        HashMap<Integer, Integer> counter = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < n && i <= k; ++i) {
            counter.compute(nums[i], (x, v) -> v == null ?  1 : v + 1);
            if(counter.get(nums[i]) > 1) return true;
        }
        for(int i = k+1; i < n; ++i) {
            counter.compute(nums[i-k-1], (x, v) -> v-1);
            counter.compute(nums[i], (x, v) -> v == null ? 1 : v + 1);
            if(counter.get(nums[i]) > 1) return true;
        }
        return false;
    }
}
