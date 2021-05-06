package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;
import com.caoguodong.leetcode.print.PrintArray;

class LeetCode1720 extends MainClass {

  static {
    mainClass = new LeetCode1720();
  }

  @Override
  public void run() {
    int[] arr = new int[] {6, 2, 7, 3};
    PrintArray.printArray(decode(arr, 4));
  }

  public int[] decode(int[] encoded, int first) {
    int[] arr = new int[encoded.length + 1];
    arr[0] = first;
    for (int i = 0; i < encoded.length; i++) {
      arr[i + 1] = encoded[i] ^ arr[i];
    }
    return arr;
  }
}
