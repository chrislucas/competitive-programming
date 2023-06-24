package com.br.medium.multithreading.completablefuture;

import static com.br.medium.multithreading.completablefuture.FakeDelayedRunnable.fakeRunnableWithMessage;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
   https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
*/
public class CompletableFutureUsingRunnableAndExecutor {

  private static void checkCompletableFutureWithRunnableAndExecutor() {
    ExecutorService executorService = Executors.newCachedThreadPool();

    Arrays.asList(
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 1", 700L), executorService),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 2", 500L), executorService),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 3", 200L), executorService),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 4", 100L), executorService),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 5", 100L), executorService),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 6", 100L), executorService),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 7", 1000L), executorService),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 8", 800L), executorService))
        .forEach(CompletableFuture::join);

    executorService.shutdown();
  }

  public static void main(String[] args) {
    checkCompletableFutureWithRunnableAndExecutor();
  }
}
