package com.leetcode.changyg;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution113 {
    // 此题目 深度优先搜索算法解决，需要借助一个栈
    private List<List<Integer>> ret = new LinkedList<List<Integer>>();
    private Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    private void dfs(TreeNode root, int sum) {
        if (null == root) {
            return;
        }
        // 入栈
        path.offerLast(root.val);
        sum  = sum - root.val;
        if (null == root.left && null == root.right && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
        // 出栈
        path.pollLast();
    }
}