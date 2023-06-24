package com.br.medium.multithreading.completablefuture;

import static com.br.medium.multithreading.completablefuture.FakeDelayedRunnable.fakeRunnableWithMessage;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

/*
   https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
*/

public class CompletableFutureUsingRunnable {

  private static void checkCompletableFutureUsingJustRunnable() {

    Arrays.asList(
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 1")),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 2")),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 3")),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 4")),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 5")),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 6")),
            CompletableFuture.runAsync(fakeRunnableWithMessage("Task 7")))
        .forEach(CompletableFuture::join);
  }

  public static void main(String[] args) {
    checkCompletableFutureUsingJustRunnable();
  }
}
