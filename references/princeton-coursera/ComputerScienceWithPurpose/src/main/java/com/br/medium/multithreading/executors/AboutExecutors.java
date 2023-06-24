package com.br.medium.multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AboutExecutors {

  static final ExecutorService NEW_CACHED_THREAD_POOL = Executors.newCachedThreadPool();

  private static ExecutorService getFixedThreadPoo(int size) {
    return Executors.newFixedThreadPool(size);
  }

  public static void main(String[] args) {}
}
