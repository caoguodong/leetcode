package com.caoguodong.leetcode.print;

public class PrintArray extends Print {

  public static void printArray(int[] nums) {
    printArray(nums, 0, nums.length);
  }

  public static void printArray(int[] nums, int end) {
    printArray(nums, 0, end);
  }

  public static void printArray(int[] nums, int start, int end) {
    String print = "";
    for (int i = start; i < end; i++) {
      print = print + nums[i];
      if (i != end - 1) {
        print = print + ",";
      }
    }
    println(print);
  }
}
