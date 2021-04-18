package com.caoguodong.leetcode;

public class MainClass {

  protected static MainClass mainClass;

  public static void main(String[] args) {
    mainClass.run();
  }

  public void run() {}

  public static void print(Object object) {
    System.out.print(object);
  }

  public static void println(Object object) {
    System.out.println(object);
  }
}
