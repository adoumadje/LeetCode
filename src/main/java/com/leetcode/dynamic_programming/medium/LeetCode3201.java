package com.leetcode.dynamic_programming.medium;

public class LeetCode3201 {
    public int maximumLength(int[] nums) {
        int eo, oe, oo, ee;
        eo = oe = oo = ee = 0;
        int eon, oen;
        eon = 0;
        oen = 1;
        for(int x: nums) {
            if(x%2 == 0) {
                ee += 1;
            } else {
                oo += 1;
            }
            if(x%2 == eon) {
                eo += 1;
                eon = (eon + 1) % 2;
            }
            if(x%2 == oen) {
                oe += 1;
                oen = (oen + 1) % 2;
            }
        }
        return Math.max(Math.max(ee, oo), Math.max(eo, oe));
    }
}
