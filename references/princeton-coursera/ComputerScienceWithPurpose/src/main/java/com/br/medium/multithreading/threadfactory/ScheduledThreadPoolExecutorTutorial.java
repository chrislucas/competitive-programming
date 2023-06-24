package com.br.medium.multithreading.threadfactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTutorial {

  /*
     https://www.geeksforgeeks.org/scheduledthreadpoolexecutor-class-in-java/
     TODO
  */

  private static void checkScheduledThread() throws ExecutionException, InterruptedException {
    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(4);

    Callable<Integer> c1 =
        () -> {
          System.out.printf("Thread Inside Callable #1: %s\n", Thread.currentThread().getName());
          return 12;
        };
    ScheduledFuture<Integer> sf1 = scheduledThreadPoolExecutor.schedule(c1, 2, TimeUnit.SECONDS);
    System.out.printf("Result: %d\n", sf1.get());

    Callable<String> c2 =
        () -> {
          System.out.printf("Thread Inside Callable #2: %s", Thread.currentThread().getName());
          return "Hello World";
        };
    ScheduledFuture<String> sf2 = scheduledThreadPoolExecutor.schedule(c2, 2, TimeUnit.SECONDS);
    System.out.printf("Result: %s\n", sf2.get());

    scheduledThreadPoolExecutor.shutdown();
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    checkScheduledThread();
  }
}
