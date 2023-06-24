package com.br.medium.multithreading.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

/*
   https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
*/

public class CompletableFutureSupplyAsync {

  @FunctionalInterface
  interface NoArgFunction<R> {
    R execute();
  }

  public static Function<Void, Integer> get() {
    return unused -> 1;
  }

  public static <R> Supplier<R> makeSupplier(NoArgFunction<R> fn) {
    System.out.printf("Thread Inside Supplier Maker: %s\n", Thread.currentThread().getName());
    return fn::execute;
  }

  private static void checkSupplierInterface() {
    Supplier<Integer> fn =
        () -> {
          System.out.printf("Thread Inside Supplier: %s\n", Thread.currentThread().getName());
          return 12;
        };
    Supplier<Integer> fn2 = makeSupplier(() -> 12);
    Supplier<String> fn3 = makeSupplier(() -> "Chris Lucas");

    CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(fn);
    System.out.println(cf1.join());
    CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(fn2);
    System.out.println(cf2.join());
    CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(fn3);
    System.out.println(cf3.join());
  }

  private static void checkThreadInsiderSuppliers() {
    Supplier<String> s1 =
        () ->
            String.format(
                "Task:#1 -Thread Inside Supplier: %s\n", Thread.currentThread().getName());

    CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(s1);
    System.out.println(cf1.join());

    System.out.println("************************************************************************");

    Supplier<String> s2 =
        () ->
            String.format(
                "Task:#2 -Thread Inside Supplier: %s\n", Thread.currentThread().getName());
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(s2, cachedThreadPool);
    System.out.println(cf2.join());

    System.out.println("************************************************************************");

    if (!cachedThreadPool.isShutdown()) {
      Supplier<String> s3 =
          () ->
              String.format(
                  "Task:#3 -Thread Inside Supplier: %s\n", Thread.currentThread().getName());
      ExecutorService unconfigurableExecutorService =
          Executors.unconfigurableExecutorService(cachedThreadPool);
      CompletableFuture<String> cf3 =
          CompletableFuture.supplyAsync(s3, unconfigurableExecutorService);
      System.out.println(cf3.join());
      unconfigurableExecutorService.shutdown();
    } else {
      cachedThreadPool.shutdown();
    }
    System.out.println("************************************************************************");
    System.out.printf("Thread: %s\n", Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    checkThreadInsiderSuppliers();
  }
}
