package com.br.medium.multithreading.completablefuture.callbacks;

import java.util.concurrent.TimeUnit;

public class ThreadHelper {

  public static void fakeEffort(int seconds) {
    try {
      TimeUnit.SECONDS.sleep(seconds);
    } catch (InterruptedException e) {
      System.err.println(e.getMessage());
    }
  }
}
