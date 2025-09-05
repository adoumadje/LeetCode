package com.leetcode.dynamic_programming.medium;

public class LeetCode1227 {
//    public double nthPersonGetsNthSeat(int n) {
//        if(n == 1) return 1.0;
//        return ( 1.0 / n) + ((double) (n - 2) / n) * nthPersonGetsNthSeat(n-1);
//    }

    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }
}
