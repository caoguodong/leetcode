package com.caoguodong.leetcode.code;

import com.caoguodong.leetcode.MainClass;

/**
 * title: 解码方法
 *
 * <p>link:https://leetcode-cn.com/problems/decode-ways/
 *
 * <p>级别：mid
 */
class LeetCode91 extends MainClass {

  static {
    mainClass = new LeetCode91();
  }

  @Override
  public void run() {
    println(numDecodings("10011111111"));
  }

  public int numDecodings(String s) {
    int n = s.length();
    int[] f = new int[n + 1];
    f[0] = 1;
    for (int i = 1; i <= n; ++i) {
      if (s.charAt(i - 1) != '0') {
        f[i] += f[i - 1];
      }
      if (i > 1
          && s.charAt(i - 2) != '0'
          && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
        f[i] += f[i - 2];
      }
    }
    return f[n];
  }

  //  public int numDecodings(String s) {
  //
  //    if (s.startsWith("0")) {
  //      return 0;
  //    }
  //
  //    if (s.length() <= 1) {
  //      return s.length();
  //    }
  //
  //    int num = 0;
  //
  //    num += numDecodings(s.substring(1));
  //
  //    int parseInt = Integer.parseInt(s.substring(0, 2));
  //
  //    if (parseInt <= 26) {
  //      if (s.length() == 2) {
  //        num++;
  //      } else {
  //        num += numDecodings(s.substring(2));
  //      }
  //    }
  //    return num;
  //  }
}
