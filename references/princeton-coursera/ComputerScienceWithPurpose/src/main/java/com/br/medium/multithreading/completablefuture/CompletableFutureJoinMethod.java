package com.br.medium.multithreading.completablefuture;

import static com.br.medium.multithreading.completablefuture.FakeDelayedRunnable.fakeRunnableWithMessage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureJoinMethod {

  /*
     https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
  */

  private static void checkJoin(Runnable runnable) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    CompletableFuture<Void> asyncTask = CompletableFuture.runAsync(runnable, executorService);
    try {
      asyncTask.join();
    } catch (CompletionException e) {
      System.err.println(e);
    } finally {
      executorService.shutdown();
    }
  }

  private static void fakeError() throws Exception {
    throw new Exception("Fake Error");
  }

  public static void main(String[] args) {
    checkJoin(fakeRunnableWithMessage("Task 1", 1000L));
    checkJoin(
        () -> {
          System.out.printf("Task 1 - Thread: %s", Thread.currentThread().getName());
          try {
            fakeError();
          } catch (Exception e) {
            // NOTHING
          }
        });
  }
}
