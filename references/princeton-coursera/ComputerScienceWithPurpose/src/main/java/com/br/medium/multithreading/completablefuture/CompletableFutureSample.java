package com.br.medium.multithreading.completablefuture;

import static com.br.medium.multithreading.completablefuture.FakeDelayedRunnable.fakeRunnableWithMessage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class CompletableFutureSample {

  private static Callable<String> fakeCallable(String taskName) {
    return () ->
        String.format("Task::: %s | Thread: %s", taskName, Thread.currentThread().getName());
  }

  private static int randomIntRange(int min, int max) {
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

  /**
   * https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657 TODO
   *
   * <p>Futu
   *
   * @param args
   */

  /**
   * Future VS CompletableFuture Future representa um futuro resultado de uma computacao asincrona
   */
  private static void checkFuture() {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    /*
       https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
       ExecutorService e uma forma de vincular uma tarefa computacional a uma thread
       pool.
       Existem algumas thread pools em java, usamos acima o metodo newFixedThreadPool
       para criar um pool de 5 threads, podemos passar um Runnable ou um Callable
       para o metodo submit.

       Abaixo temos um array que passamos uma serie de callables para o ExecutorService. Eles
       serao executados juntos, mas a funcao que recupera o resultado de um calleable Future:get
       e bloqueante e ira esperar ate o resultado de callable ser produzido.

    */

    /*
       Desvantagens:
       - Nao podemos completar uma Future manualmente
           - Exemplo: Numa chamada de API, se ela retornar erro preciamos retornar uma resposta cacheada
       - Multiplos Futures nao podem ser encadeadas de forma que o resultado de uma possa depender ou ser combinado
       com outra

       - Nao existe exception handlers - Nao a um jeito adequado de lidar com exceptions

       - Blocking - Future.get() bloqueia a thread, assim tornando essa api sincrona

    */

    Arrays.asList(
            executorService.submit(fakeCallable("task 1")),
            executorService.submit(fakeCallable("task 2")),
            executorService.submit(fakeCallable("task 3")),
            executorService.submit(fakeCallable("task 4")),
            executorService.submit(fakeCallable("task 5")),
            executorService.submit(fakeCallable("task 6")),
            executorService.submit(
                () ->
                    String.format("Task::: Task 7 | Thread: %s", Thread.currentThread().getName())),
            executorService.submit(
                () -> {
                  System.out.printf(
                      "Task::: Task 8 | Thread: %s", Thread.currentThread().getName());
                }))
        .forEach(
            future -> {
              try {
                /*
                   O metodo get() e bloqueante
                */
                System.out.println(future.get());
              } catch (InterruptedException | ExecutionException e) {
                executorService.shutdown();
                throw new RuntimeException(e);
              }
            });
    executorService.shutdown();
  }

  private static void step() throws InterruptedException {
    int rdnInt = randomIntRange(1000, 3000);
    System.out.printf("Time: %d\n", rdnInt);
    Thread.sleep(rdnInt);
  }

  private static Callable<String> fakeCallableLongTask(String taskName) {
    return () -> {
      step();
      return String.format("Task::: %s | Thread: %s", taskName, Thread.currentThread().getName());
    };
  }

  private static void checkFutureWithLongTasks() {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    List.of(
            executorService.submit(fakeCallableLongTask("Task 1")),
            executorService.submit(fakeCallableLongTask("Task 2")),
            executorService.submit(fakeCallableLongTask("Task 3")),
            executorService.submit(fakeCallableLongTask("Task 5")),
            executorService.submit(fakeCallableLongTask("Task 6")),
            executorService.submit(fakeCallableLongTask("Task 7")))
        .forEach(
            future -> {
              try {
                System.out.println(future.get());
              } catch (InterruptedException | ExecutionException e) {
                executorService.shutdown();
                throw new RuntimeException(e);
              }
            });
    executorService.shutdown();
  }

  /*
      https://salithachathuranga94.medium.com/completablefuture-in-java-97b0b392657
      Assinatura da classe
      public class CompletableFuture<T> implements Future<T>, CompletionStage<T>

      Uma implementacao de Future e CompletionStage
         - Possui uma serie de metodos que podemos criar, executar, combinar cadeias de multiplas
         futures e possui uma forma descritiva de lidar com erros
  */
  private static void checkCompletableFutureRunAsync() {
    CompletableFuture<Void> asyncTask1 =
        CompletableFuture.runAsync(fakeRunnableWithMessage("Task 1"));

    System.out.printf(
        "Thread: %s From checkCompletableFutureRunAsync\n", Thread.currentThread().getName());

    asyncTask1.join();

    ExecutorService executorService = Executors.newCachedThreadPool();
    CompletableFuture<Void> asyncTask2 =
        CompletableFuture.runAsync(fakeRunnableWithMessage("Task 2"), executorService);
    asyncTask2.join();

    executorService.shutdown();
  }

  private static void checkCompletableFutureRunAsyncWithDelay() {
    CompletableFuture<Void> asyncTask1 =
        CompletableFuture.runAsync(fakeRunnableWithMessage("Task 1", 2000L));

    System.out.printf(
        "Thread: %s | From checkCompletableFutureRunAsync\n", Thread.currentThread().getName());

    asyncTask1.join();

    ExecutorService executorService = Executors.newCachedThreadPool();
    CompletableFuture<Void> asyncTask2 =
        CompletableFuture.runAsync(fakeRunnableWithMessage("Task 2", 1000L), executorService);
    asyncTask2.join();

    executorService.shutdown();

    /*
       Resultado
       Thread: main From checkCompletableFutureRunAsync
       Task:: Task 1 | Thread: ForkJoinPool.commonPool-worker-19
       Task:: Task 2 | Thread: pool-1-thread-1

       Thread 1: main
       -    Main Thread onde a nossa aplicacao roda
       Thread 2: ForkJoinPool.commonPool-worker-19
           - Primeira task foi executada na thread ForkJoinPool, a thread default para completable future
       Thread 3: pool-1-thread-1
           - A segunda task tem um parametro adicional, executor. Executor é uma Thread pool, e asism
           a task 2 nao utiliza a thread pool default, utiliza a cachedThreadPool

        join()
        - metodo de instancia de CompletableFuture usado para retornar um valor quando a Future for completada
        ou lancar uma excecao nao checavel. Se a task envolvida na Completion da CompletableFuture lancar uma
        excecao, entao esse join lanca CompletionException com a excecao original/subjacente como causa (
        encapsulando a excecao original)
    */
  }

  public static void main(String[] args) {
    // checkFuture();
    // checkFutureWithLongTasks();
    // checkCompletableFutureRunAsync();
    checkCompletableFutureRunAsyncWithDelay();
  }
}
