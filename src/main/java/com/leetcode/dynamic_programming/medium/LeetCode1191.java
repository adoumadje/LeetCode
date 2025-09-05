package com.leetcode.dynamic_programming.medium;

public class LeetCode1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(k == 1) return (int) kadane(arr);
        int n = arr.length;
        int[] arr2 = new int[2*n];
        long sum = 0;
        long MOD = (long) 1e9 + 7;
        for(int i = 0; i < n; ++i) {
            sum += arr[i];
            arr2[i] = arr[i];
            arr2[i+n] = arr[i];
        }
        if(sum > 0) {
            return (int) ((kadane(arr2) % MOD + ((k-2) * sum % MOD) % MOD) % MOD);
        } else {
            return (int) (kadane(arr2) % MOD);
        }
    }

    private long kadane(int[] arr) {
        long temp = 0,  res = 0;
        for(int x: arr) {
            if(temp + x < 0) {
                temp = 0;
            } else {
                temp += x;
            }
            res = Math.max(res, temp);
        }
        return res;
    }
}
