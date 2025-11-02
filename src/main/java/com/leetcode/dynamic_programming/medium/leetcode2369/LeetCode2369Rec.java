package com.leetcode.dynamic_programming.medium.leetcode2369;

public class LeetCode2369Rec {
    int n;
    int[] nums;
    Boolean[] mem;
    public boolean validPartition(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        this.mem = new Boolean[n];
        return dfs(0);
    }

    private boolean dfs(int i) {
        if(n-i < 2) return false;
        if(n-i == 2) return nums[i] == nums[i+1];
        if(n-i == 3)
            return ((nums[i] == nums[i+1] && nums[i] == nums[i+2])
            || (nums[i] + 1 == nums[i+1] && nums[i] + 2 == nums[i+2]));
        if(mem[i] != null) return mem[i];
        if((nums[i] == nums[i+1] && dfs(i+2))
        || (((nums[i] == nums[i+1] && nums[i] == nums[i+2])
                || (nums[i] + 1 == nums[i+1] && nums[i] + 2 == nums[i+2])) && dfs(i+3))) {
            return mem[i] = true;
        }
        return mem[i] = false;
    }
}
