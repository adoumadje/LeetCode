package com.leetcode.daily.Y2025.july;

public class LeetCode2210 {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 1; i < n-1; ++i) {
            int j = i;
            while(j < n-2 && nums[j] == nums[j+1]) ++j;
            if((nums[i-1] < nums[i] && nums[j+1] < nums[j])
            || (nums[i-1] > nums[i] && nums[j+1] > nums[j])) {
                ++count;
            }
            i = j;
        }
        return count;
    }
}
