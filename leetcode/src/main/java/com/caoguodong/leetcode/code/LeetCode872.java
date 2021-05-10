package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;
import java.util.ArrayList;
import java.util.List;

public class LeetCode872 extends MainClass {

  public class TreeNode {
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

  static {
    mainClass = new LeetCode872();
  }

  @Override public void run() {

  }

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {

    List<Integer> leaf1 = leaf(root1, new ArrayList<>());
    List<Integer> leaf2 = leaf(root2, new ArrayList<>());

    if (leaf1.size() != leaf2.size()) {
      return false;
    }

    for (int i = 0; i < leaf1.size(); i++) {
      if (leaf1.get(i) != leaf2.get(i)) {
        return false;
      }
    }

    return true;
  }

  private List<Integer> leaf(TreeNode root1, List<Integer> result) {
    if (root1.left != null) {
      leaf(root1.left, result);
    }

    if (root1.right != null) {
      leaf(root1.right, result);
    }

    if (root1.left == null && root1.right == null) {
      result.add(root1.val);
    }
    return result;
  }
}
