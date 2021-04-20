package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;

/**
 * title: 实现 strStr()
 *
 * <p>link:https://leetcode-cn.com/problems/implement-strstr/
 *
 * <p>级别：easy
 */
class LeetCode28 extends MainClass {
  static {
    mainClass = new LeetCode28();
  }

  @Override
  public void run() {
    println(strStr("hello", "ll"));
  }

  public int strStr(String haystack, String needle) {

    if (needle.length() == 0) {
      return 0;
    } else if (haystack.length() == 0) {
      return -1;
    }

    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        String substring = haystack.substring(i, i + needle.length());
        if (substring.equals(needle)) {
          return i;
        }
      }
    }
    return -1;
  }
}
