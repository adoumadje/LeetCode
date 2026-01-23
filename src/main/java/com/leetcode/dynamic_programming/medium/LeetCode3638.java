package com.leetcode.dynamic_programming.medium;

import java.util.Stack;

public class LeetCode3638 {
    public int maxBalancedShipments(int[] weight) {
        int count = 0;
        int n = weight.length;
        for(int i = 0; i + 1 < n; ++i) {
            if(weight[i] > weight[i+1]) {
                count += 1;
                i += 1;
            }
        }
        return count;
    }
}
