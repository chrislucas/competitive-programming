package com.br.medium.randomrange;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomRange {

  /*
     https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
     e
     https://www.baeldung.com/java-generating-random-numbers-in-range
  */
  private static int randomRange1(int min, int max) {
    return new Random().nextInt(max - min + 1) + min;
  }

  /**
   * https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
   *
   * @param min
   * @param max
   * @return random numnber between min and max
   */
  private static int randomRange2(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max);
  }

  /*
     https://www.baeldung.com/java-generating-random-numbers-in-range
  */

  private static int randomRange3(int min, int max) {
    return new Random().ints(min, max).findFirst().getAsInt();
  }

  public static void main(String[] args) {
    System.out.println(randomRange3(1000, 5000));
    System.out.println(randomRange3(2000, 3500));
  }
}
