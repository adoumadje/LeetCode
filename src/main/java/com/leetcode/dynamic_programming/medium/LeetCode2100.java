package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] left = new int[n], right = new int[n];
        for(int i = 1; i < n; ++i) {
            if(security[i-1] >= security[i]) left[i] = 1 + left[i-1];
            int j = n-1-i;
            if(security[j+1] >= security[j]) right[j] = 1 + right[j+1];
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            if(Math.min(left[i], right[i]) >= time) res.add(i);
        }
        return res;
    }
}
