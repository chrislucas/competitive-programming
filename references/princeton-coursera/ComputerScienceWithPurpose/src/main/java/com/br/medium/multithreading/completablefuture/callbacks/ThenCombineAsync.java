package com.br.medium.multithreading.completablefuture.callbacks;

import static com.br.medium.multithreading.completablefuture.callbacks.ThreadHelper.fakeEffort;

import java.util.concurrent.CompletableFuture;

public class ThenCombineAsync {

  /*
     https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
  */

  private static CompletableFuture<String> getWeather() {
    return CompletableFuture.supplyAsync(
        () -> {
          fakeEffort(5);
          return "28 graus celsius";
        });
  }

  private static CompletableFuture<String> getGreetings(final String name) {
    return CompletableFuture.supplyAsync(
        () -> {
          fakeEffort(5);
          return String.format("Ola, %s", name);
        });
  }

  private static void checkCallbackThenCombineAsync() {
    CompletableFuture<String> result =
        getGreetings("Chris")
            .thenCombineAsync(
                getWeather(),
                (greeting, weather) -> {
                  System.out.printf("Log: [Thread: %s]\n", Thread.currentThread().getName());
                  return String.format("%s, está %s", greeting, weather);
                });

    System.out.println(result.join());
  }

  public static void main(String[] args) {
    checkCallbackThenCombineAsync();
  }
}
