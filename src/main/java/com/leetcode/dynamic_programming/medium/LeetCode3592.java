package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode3592 {
    public List<Integer> findCoins(int[] numWays) {
        List<Integer> res = new ArrayList<>();
        int n = numWays.length;
        int[] nums = new int[n+1];
        nums[0] = 1;
        System.arraycopy(numWays, 0, nums, 1, n);
        int right = 1;
        while (true) {
            while (right <= n && nums[right] == 0) right++;
            if(right > n) {
                return res;
            } else if (nums[right] != 1) {
                return new ArrayList<>();
            } else {
                res.add(right);
            }

            for(int i = n; i >= right; --i) {
                if(nums[i-right] > 0) {
                    if(nums[i] > 0) {
                        nums[i] -= nums[i-right];
                    } else {
                        return new ArrayList<>();
                    }
                }
            }
        }
    }
}
