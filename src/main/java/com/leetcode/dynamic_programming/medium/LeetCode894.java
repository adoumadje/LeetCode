package com.leetcode.dynamic_programming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode894 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     *      Solution
     */

    List<TreeNode>[] mem;
    public List<TreeNode> allPossibleFBT(int n) {
        mem = new List[n+1];
        return dfs(n);
    }

    public List<TreeNode> dfs(int n) {
        if(n == 0) return new ArrayList<>();
        if(n == 1) return Arrays.asList(new TreeNode(0));
        if(mem[n] != null) return mem[n];
        List<TreeNode> res = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            List<TreeNode> lefts = dfs(i);
            List<TreeNode> rights = dfs(n-1-i);
            for(TreeNode l: lefts) {
                for(TreeNode r: rights) {
                    res.add(new TreeNode(0, l, r));
                }
            }
        }
        return mem[n] = res;
    }
}
