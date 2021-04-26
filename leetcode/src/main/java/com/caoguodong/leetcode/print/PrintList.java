package com.caoguodong.leetcode.print;

import java.util.List;

public class PrintList extends PrintArray {
  public static void printList(List<Integer> list) {
    int[] array = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    printArray(array, 0, list.size());
  }
}
