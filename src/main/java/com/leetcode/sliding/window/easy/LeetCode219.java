package com.leetcode.sliding.window.easy;

import java.util.HashMap;

public class LeetCode219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> indexer = new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            if(indexer.containsKey(nums[i]) && i - indexer.get(nums[i]) <= k)
                return true;
            indexer.put(nums[i], i);
        }
        return false;
    }
}
