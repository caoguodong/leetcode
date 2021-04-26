package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;
import java.util.Arrays;

/**
 * title: 在 D 天内送达包裹的能力
 *
 * <p>link:https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * <p>级别：mid
 */
public class LeetCode1011 extends MainClass {
  static {
    mainClass = new LeetCode1011();
  }

  @Override public void run() {
    int[] weights = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    print(shipWithinDays(weights, 5));
  }

  public int shipWithinDays(int[] weights, int D) {
    int right = Arrays.stream(weights).sum();
    int left = Arrays.stream(weights).max().getAsInt();

    while (left < right) {
      int mid = (left + right) / 2;
      int days = 1;
      int count = 0;
      for (int weight : weights) {
        if (count + weight > mid) {
          count = 0;
          days++;
        }
        count += weight;
      }

      if (days > D) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
