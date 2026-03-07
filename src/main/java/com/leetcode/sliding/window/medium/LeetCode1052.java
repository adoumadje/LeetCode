package com.leetcode.sliding.window.medium;

public class LeetCode1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0, saved = 0, l = 0, bestSave = 0;
        int n = customers.length;
        for(int r = 0; r < n; ++r) {
            if(grumpy[r] == 0) {
                satisfied += customers[r];
            } else {
                saved += customers[r];
            }

            if(r-l+1 < minutes) continue;
            if(r-l+1 > minutes) {
                if(grumpy[l] == 1) {
                    saved -= customers[l];
                }
                l += 1;
            }
            bestSave = Math.max(bestSave, saved);
        }
        return satisfied + bestSave;
    }
}
