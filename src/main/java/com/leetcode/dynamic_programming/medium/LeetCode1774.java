package com.leetcode.dynamic_programming.medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode1774 {
    int[] topping;
    int target;
    int closest = 0;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        this.target = target;
        this.topping = toppingCosts;
        Set<Integer> base = Arrays.stream(baseCosts).boxed().collect(Collectors.toSet());
        closest = target > Integer.MAX_VALUE - target ? 0 : Integer.MAX_VALUE;
        for(int b: base) {
            dfs(b, 0);
        }
        return closest;
    }

    private void dfs(int cost, int i) {
        if(i == topping.length) {
            if(Math.abs(cost - target) < Math.abs(closest - target)) {
                closest = cost;
            } else if(Math.abs(cost - target) == Math.abs(closest - target)) {
                closest = Math.min(closest, cost);
            }
        } else {
            dfs(cost + 0 * topping[i], i+1);
            dfs(cost + 1 * topping[i], i+1);
            dfs(cost + 2 * topping[i], i+1);
        }

    }
}
