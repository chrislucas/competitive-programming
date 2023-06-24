package com.br.medium.multithreading.completablefuture.callbacks;

import static com.br.medium.multithreading.completablefuture.callbacks.ThreadHelper.fakeEffort;

import java.util.concurrent.CompletableFuture;

public class ThenApplyAsync {

  /*
     https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
     - thenApplyAsync(fn)

     - thenApplyAsync(fn,exec)
     Executa fn num "ambiente de execucao (enviroment-defined executor)" independente dea circunstancia
     Para CompletableFutre esse "ambiente"geralmente sera um ForkJoinPool.commonPool()
  */

  private static void checkThenAsyncWithoutPassExecutor() {
    CompletableFuture<String> message =
        CompletableFuture.supplyAsync(
            () -> {
              fakeEffort(5);
              return "Uma mensagem qualquer";
            });
  }

  private static void checkThenAsyncPassingExecutor() {}

  public static void main(String[] args) {}
}
