package com.leetcode.sliding.window.medium;

public class LeetCode978 {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length, l = 0;
        int res = 1;
        for(int r = 1; r < n; ++r) {
            if(arr[r] == arr[r-1]) {
                l = r;
            } else if (r-l == 1) {
                // Good
            } else if ((arr[r - 2] > arr[r - 1] && arr[r] > arr[r - 1])
            || (arr[r-2] < arr[r-1] && arr[r] < arr[r-1])) {
                // Good
            } else {
                l = r-1;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
