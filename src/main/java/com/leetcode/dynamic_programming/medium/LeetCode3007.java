package com.leetcode.dynamic_programming.medium;

public class LeetCode3007 {
    public long findMaximumNumber(long k, int x) {
        long INF = (long) 1e15;
        long left = 0, right = INF, last = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if(good(mid, k, x)) {
                System.out.println("left = " + left + ", right = " + right);
                left = mid + 1;
                last = mid;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }

    private boolean good(long num, long k, int x) {
        int index = x;
        long group = (long) Math.pow(2, index-1);
        long total = 0;
        long counter = num >> (x-1);
        num += 1;
        while (counter > 0) {
            long numGroup = num / group;
            total += (numGroup / 2) * group;
            if(numGroup % 2 == 1) total += num % group;
            counter = counter >> x;
            index += x;
            group = (long) Math.pow(2, index-1);
        }
        return total <= k;
    }
}
