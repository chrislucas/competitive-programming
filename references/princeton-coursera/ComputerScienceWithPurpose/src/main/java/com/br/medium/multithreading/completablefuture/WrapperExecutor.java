package com.br.medium.multithreading.completablefuture;

import static com.br.medium.multithreading.completablefuture.FakeDelayedRunnable.fakeRunnableWithMessage;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

public class WrapperExecutor {

  final ExecutorService executorService;
  final String taskName;

  public WrapperExecutor(ExecutorService executorService, String taskName) {
    this.executorService = executorService;
    this.taskName = taskName;
  }

  public void delayedRunAsync(long delay) {
    CompletableFuture<Void> asyncTask =
        CompletableFuture.runAsync(fakeRunnableWithMessage(taskName, delay), executorService);
    asyncTask.join();
    executorService.shutdown();
  }

  public <U> U delayedSupply(Supplier<U> supplier) {
    CompletableFuture<U> asyncTask = CompletableFuture.supplyAsync(supplier, executorService);
    U result = asyncTask.join();
    executorService.shutdown();

    return result;
  }
}
