package com.leetcode.dynamic_programming.medium.leetcode3388;

public class LeetCode3388ZFunction {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        int[] z = zFunction(nums, 0);
        int beautiful = 0;
        for(int i = 1; i < n; ++i) {
            if(z[i] >= i) beautiful += n - 2*i;
            int[] zn = zFunction(nums, i);
            for(int j = i+1; j < n; ++j) {
                if(zn[j] >= j - i && (z[i] < i || j < 2*i))
                    beautiful += 1;
            }
        }
        return beautiful;
    }

    private int[] zFunction(int[] nums, int offset) {
        int n = nums.length;
        int[] z = new int[n];
        int left = offset, right = offset;
        for(int i = offset+1; i < n; ++i) {
            if(i > offset) {
                left = right = i;
                while (right < n && nums[right] == nums[right-left+offset])
                    right++;
                z[i] = right-left;
                right--;
            } else {
                int k = i - left + offset;
                if(z[k] < right - i + 1) {
                    z[i] = z[k];
                } else {
                    left = i;
                    while (right < n && nums[right] == nums[right-left+offset])
                        right++;
                    z[i] = right-left;
                    right--;
                }
            }
        }
        return z;
    }
}
