package com.br.medium.multithreading.completablefuture;

public class FakeDelayedRunnable {

  public static Runnable fakeRunnableWithMessage(String message) {
    return fakeRunnableWithMessage(message, 0L);
  }

  public static Runnable fakeRunnableWithMessage(String message, Long delay) {
    return () -> {
      try {
        Thread.sleep(delay);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.printf("Task:: %s | Thread: %s\n", message, Thread.currentThread().getName());
    };
  }
}
