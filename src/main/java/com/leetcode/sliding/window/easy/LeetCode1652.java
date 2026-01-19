package com.leetcode.sliding.window.easy;

public class LeetCode1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        int kk = Math.abs(k);
        if(k == 0) return new int[n];
        int left = 0, sum = 0;
        for(int right = 0; right < 2*n; ++right) {
            int ri = right%n;
            int li = left%n;
            sum += code[ri];
            if(right-left >= kk) {
                sum -= code[li];
                left += 1;
                int idx = (k > 0 ? left-1 : right+1) % n;
                res[idx] = sum;
            }
        }
        return res;
    }
}
