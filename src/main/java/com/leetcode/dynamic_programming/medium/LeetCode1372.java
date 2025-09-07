package com.leetcode.dynamic_programming.medium;

public class LeetCode1372 {
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

    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, true, 0), dfs(root.right, false, 0));
    }

    private int dfs(TreeNode node, boolean isLeft, int depth) {
        if(node == null) return depth;
        if(isLeft) {
            depth = Math.max(dfs(node.left, true, 0),
                    dfs(node.right, false, depth + 1));
        } else {
            depth = Math.max(dfs(node.right,  false, 0),
                    dfs(node.left, true, depth + 1));
        }
        return depth;
    }
}
