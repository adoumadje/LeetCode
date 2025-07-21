package com.leetcode.dynamic_programming.medium;

public class LeetCode845 {
    public int longestMountain(int[] arr) {
        int up = 0, down = 0, n = arr.length;
        int res = 0;
        for(int i = 0; i < n-1; ++i) {
            if(arr[i] < arr[i+1]) {
                if(down > 0) {
                    up = 0;
                    down = 0;
                }
                ++up;
            } else if (up > 0 && arr[i] > arr[i+1]) {
                ++down;
            } else {
                up = 0;
                down = 0;
            }

            if(up > 0 && down > 0) {
                res = Math.max(res, up + down + 1);
            }
        }
        return res;
    }
}
