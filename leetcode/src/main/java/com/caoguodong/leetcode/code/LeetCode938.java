package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;

/**
 * title:二叉搜索树的范围和
 *
 * <p>link:https://leetcode-cn.com/problems/range-sum-of-bst/
 *
 * <p>级别：easy
 */
public class LeetCode938 extends MainClass {
  static {
    mainClass = new LeetCode938();
  }

  @Override public void run() {
    TreeNode root = new TreeNode();
  }

  public int rangeSumBST(TreeNode root, int low, int high) {
    return dfs(root, low, high, 0);
  }

  public int dfs(TreeNode root, int low, int high, int sum) {

    if (root == null) return sum;

    if (root.val > low) {
      int temp = sum;
      sum += dfs(root.left, low, high, 0);
    }

    if (root.val < high) {
      int temp = sum;
      sum += dfs(root.right, low, high, 0);
    }

    if (root.val >= low && root.val <= high) {
      sum += root.val;
    }

    return sum;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
