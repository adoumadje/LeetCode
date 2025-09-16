package com.leetcode.dynamic_programming.medium;

public class LeetCode1524 {
    public int numOfSubarrays(int[] arr) {
        int prevOdd = 0, prevEven = 0;
        long MOD = (long) 1e9 + 7;
        long res = 0;
        int currOdd, currEven;
        for(int x: arr) {
            if(x % 2 == 0) {
                currOdd = prevOdd;
                currEven = prevEven + 1;
            } else {
                currOdd = prevEven + 1;
                currEven = prevOdd;
            }
            res += currOdd;
            prevEven = currEven;
            prevOdd = currOdd;
        }
        return (int) (res % MOD);
    }
}
