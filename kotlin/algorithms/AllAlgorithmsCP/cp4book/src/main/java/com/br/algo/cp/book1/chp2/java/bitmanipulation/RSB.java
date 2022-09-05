package com.br.algo.cp.book1.chp2.java.bitmanipulation;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class RSB {

  /*
     https://www.geeksforgeeks.org/position-of-rightmost-set-bit/
     https://stackoverflow.com/questions/31393100/how-to-get-position-of-right-most-set-bit-in-c
  */

  static int rsb(int value) {
    return value & (-value);
  }

  static void getPatternRsb() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= (2 << 10); i++) {
      // sb.append(String.format("rsb(%d) = %d\n", i, rsb(i)));
      sb.append(String.format(i == 1 ? "%d" : " %d", rsb(i)));
    }
    System.out.println(sb);
  }

  static void mappingPatternRsb(int size) {
    StringBuilder sb = new StringBuilder();
    Map<String, Integer> map = new LinkedHashMap<>();
    for (int i = 1; i <= (2 << 20); i++) {
      sb.append(rsb(i));
      if (i % size == 0) {
        String pttr = sb.toString();
        if (map.getOrDefault(pttr, 0) == 0) {
          map.put(pttr, 1);
        } else {
          map.put(pttr, 1 + map.get(pttr));
        }
        sb = new StringBuilder();
      }
    }

    map.forEach(
        (key, val) -> {
          System.out.printf("%s = %d\n", key, val);
        });

    int value = map.values().stream().reduce(Integer::sum).orElseGet(() -> -1);
    System.out.printf("Soma = %d", value);
  }

  private void checkMappingPattern() {
    mappingPatternRsb(4);
    System.out.println();
    mappingPatternRsb(8);
    System.out.println();
    mappingPatternRsb(16);
    System.out.println();
    mappingPatternRsb(32);
    System.out.println();
    mappingPatternRsb(64);
    System.out.println();
    mappingPatternRsb(128);
  }

  private static String toBinary(int value) {
    StringBuilder sb = new StringBuilder();
    while (value > 0) {
      sb.append((value & 1) == 1 ? "1" : "0");
      value >>= 1;
    }
    return sb.reverse().toString();
  }

  private static void removeRsb(int value) {
    StringBuilder sb = new StringBuilder();
    while (value > 0) {
      sb.append(String.format("%d(%s)\n", value, toBinary(value)));
      value -= rsb(value);
    }
    System.out.println(sb);
  }

  private static void checkRemoveRsb() {
    Arrays.stream(new int[] {11, 127, 63, 31, 10}).forEach(RSB::removeRsb);
  }

  private static void addRsb(int value, int limit) {
    StringBuilder sb = new StringBuilder();
    while (value < limit) {
      sb.append(String.format("%d(%s)\n", value, toBinary(value)));
      value += rsb(value);
    }
    System.out.println(sb);
  }

  private static void checkAddRsb() {
    addRsb(0, 127);
  }

  public static void main(String[] args) {
    checkAddRsb();
  }
}
