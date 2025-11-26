package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2830 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int[] dp = new int[n];
        Map<Integer, List<List<Integer>>> endToOffer = new HashMap<>();
        for(List<Integer> offer: offers) {
            Integer end = offer.get(1);
            endToOffer.computeIfAbsent(end, k -> new ArrayList<>());
            endToOffer.get(end).add(offer);
        }
        for(int i = 0; i < n; ++i) {
            dp[i] = i > 0 ? dp[i-1] : 0;
            if(!endToOffer.containsKey(i)) continue;
            for (List<Integer> offer: endToOffer.get(i)) {
                int start = offer.get(0);
                int prev = start > 0 ? dp[start-1] : 0;
                dp[i] = Math.max(dp[i], offer.get(2) + prev);
            }
        }
        return dp[n-1];
    }
}
