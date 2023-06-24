package com.br.medium.multithreading.completablefuture.callbacks;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

public class ThenApply {

  /*
     https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
     Callback Methods
     - Utilizados para encadear Futures e fazer o que quisermos com elas
         ThenApplyAsync, ThenAcceptAsync, ThenAcceptAsync, ThenRunAsync, ThenComposeAsync, ThenCombineAsync

  */

  private static void checkCallbackMethodsThenApply() {
    CompletableFuture<String> cf1 =
        CompletableFuture.supplyAsync(
            () -> String.format("Hello World #1: Thread: %s", Thread.currentThread().getName()));

    /*
       ThenApply(fn) Executa funcao FN numa thread definida pela CompletableFuture que ela é
       chamado, assim geralmente nao sabemos onde ela sera executada. Pode ser imediatamente
       executda se o resultado estiver disponivel
    */
    cf1.thenApply(
        (Function<String, Void>)
            s -> {
              System.out.printf("Result: [%s]\nThread: %s\n", s, Thread.currentThread().getName());
              return null;
            });

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    CompletableFuture<String> cf2 =
        CompletableFuture.supplyAsync(
            () -> String.format("Hello World #2: Thread: %s", Thread.currentThread().getName()),
            executorService);
    cf2.thenApply(
        (Function<String, Void>)
            s -> {
              System.out.printf("Result: [%s]\nThread: %s\n", s, Thread.currentThread().getName());
              return null;
            });

    executorService.shutdown();

    CompletableFuture<String> cf3 =
        CompletableFuture.supplyAsync(
            () -> "Hello World #3".concat(" ").concat(Thread.currentThread().getName()));

    cf3.thenApply(
        (Function<String, Void>)
            s -> {
              System.out.printf("Result: [%s]\nThread: %s\n", s, Thread.currentThread().getName());
              return null;
            });
  }

  public static void main(String[] args) {
    checkCallbackMethodsThenApply();
  }
}
