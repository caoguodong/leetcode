package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;
import com.caoguodong.leetcode.print.PrintArray;

/**
 * title: 移除元素
 *
 * <p>link:https://leetcode-cn.com/problems/remove-element/
 *
 * <p>级别：easy
 */
class LeetCode27 extends MainClass {
  static {
    mainClass = new LeetCode27();
  }

  @Override
  public void run() {
    int[] nums = new int[] {3, 2, 2, 3};
    PrintArray.printArray(nums, removeElement(nums, 3));
  }

  public int removeElement(int[] nums, int val) {
    int start = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == val) {
        continue;
      }
      nums[start] = nums[i];
      start++;
    }
    return start;
  }
}
