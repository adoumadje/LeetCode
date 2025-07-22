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

    boolean[] valid;

    public List<TreeNode> allPossibleFBT(int n) {
        if(n == 1) return Arrays.asList(new TreeNode(0));
        valid = new boolean[n];
        valid[1] = true;
        for(int i = 2; i < n-1; i *= 2) {
            valid[i+1] = true;
        }
        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        if(n == 1) {
            return Arrays.asList(new TreeNode(0));
        }
        List<TreeNode> res = new ArrayList<>();
        for(int i = 0; i < n; ) {

            int x = i+1;
            int y = n-1-x;
            if(y >= 0 && valid[x] && valid[y]) {
                List<TreeNode> lefts = dfs(x);
                List<TreeNode> rights = dfs(y);
                for(TreeNode l: lefts) {
                    for(TreeNode r: rights) {
                        TreeNode node = new TreeNode(0);
                        node.left = l;
                        node.right = r;
                        res.add(node);
                    }
                }
            }
            i = i == 0 ? 2 : i*2;
        }
        return res;
    }
}
