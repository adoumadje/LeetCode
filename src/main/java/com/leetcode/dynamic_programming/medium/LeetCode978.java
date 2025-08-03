package com.leetcode.dynamic_programming.medium;

public class LeetCode978 {
    public int maxTurbulenceSize(int[] arr) {
        int res = 0;
        int prev = 0;
        int n  = arr.length;
        int temp = 0;
        for(int i = 0; i < n-1; ++i) {
            int curr = arr[i+1] - arr[i];
            if(curr == 0) {
                temp = 0;
            } else {
                if ((prev < 0 && curr > 0) ||  (prev > 0 && curr < 0)) {
                    ++temp;
                } else {
                    temp = 2;
                }
            }
            res = Math.max(res, temp);
            prev = curr;
        }
        return res;
    }
}
