package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;
import com.caoguodong.leetcode.print.PrintArray;
import com.caoguodong.leetcode.print.PrintList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode368 extends MainClass {
  static {
    mainClass = new LeetCode368();
  }

  @Override public void run() {
    int[] array = new int[] { 3, 4, 16, 8 };
    PrintList.printList(largestDivisibleSubset(array));
  }

  public List<Integer> largestDivisibleSubset(int[] nums) {
    int length = nums.length;
    int[] dp = new int[length];

    Arrays.sort(nums);
    Arrays.fill(dp, 1);

    int maxLength = 1;
    int maxLengthIndex = 0;
    dp[0] = 1;
    for (int i = 1; i < length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
          maxLength = Math.max(dp[i], maxLength);
          if (dp[i] == maxLength) {
            maxLengthIndex = i;
          }
        }
      }
    }

    int nextLengthIndex = maxLengthIndex;
    int nextLength = maxLength - 1;
    List<Integer> result = new ArrayList<>(maxLength);
    result.add(nums[maxLengthIndex]);
    for (int i = maxLengthIndex - 1; i >= 0; i--) {
      if (dp[i] == nextLength && nums[nextLengthIndex] % nums[i] == 0) {
        result.add(0, nums[i]);
        nextLength--;
        nextLengthIndex = i;
      }
      if (nextLength <= 0) {
        break;
      }
    }

    return result;
  }
}
