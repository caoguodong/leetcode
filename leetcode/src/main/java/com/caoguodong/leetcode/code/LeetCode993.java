package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode993 extends MainClass {
  static {
    mainClass = new LeetCode993();
  }

  @Override public void run() {

  }

  private int x, y;
  private boolean xFound, yFound;
  private TreeNode xParent, yParent;
  private int xDepth, yDepth;

  public boolean isCousins(TreeNode root, int x, int y) {

    this.x = x;
    this.y = y;

    Queue<TreeNode> nodeList = new LinkedList<>();
    Queue<Integer> depthList = new LinkedList<>();
    nodeList.offer(root);
    depthList.offer(0);

    while (!nodeList.isEmpty()) {
      TreeNode node = nodeList.poll();
      int depth = depthList.poll();

      if (node.left != null) {
        nodeList.offer(node.left);
        depthList.offer(depth + 1);
        update(node.left, node, depth + 1);
      }

      if (node.right != null) {
        nodeList.offer(node.right);
        depthList.offer(depth + 1);
        update(node.right, node, depth + 1);
      }

      if (xFound && yFound) {
        break;
      }
    }

    return xDepth == yDepth && xParent != yParent;
  }

  public void update(TreeNode node, TreeNode parent, int depth) {
    if (node.val == x) {
      xParent = parent;
      xDepth = depth;
      xFound = true;
    } else if (node.val == y) {
      yParent = parent;
      yDepth = depth;
      yFound = true;
    }
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
