package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;
import java.util.TreeSet;

/**
 * title: 存在重复元素 III
 *
 * <p>link:https://leetcode-cn.com/problems/contains-duplicate-iii/
 *
 * <p>级别：mid
 */
class LeetCode220 extends MainClass {

  static {
    mainClass = new LeetCode220();
  }

  @Override
  public void run() {
    boolean result = containsNearbyAlmostDuplicate(new int[] {2147483640, 2147483641}, 1, 100);
    println("LeetCode220:" + result);
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    TreeSet<Long> treeSet = new TreeSet();
    for (int i = 0; i < nums.length; i++) {
      Long ceiling = treeSet.ceiling((long) nums[i] - (long) t);
      if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
        return true;
      }
      treeSet.add((long) nums[i]);
      if (i >= k) {
        treeSet.remove((long) nums[i - k]);
      }
    }
    return false;
  }
}
