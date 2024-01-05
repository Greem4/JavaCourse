package edu.javacourse.thread.threadeight;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class Starter {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final int MAX = 16;
        List<Integer> test = IntStream
                .range(1, MAX + 1)
                .boxed()
                .toList();

//        Spliterator<Integer> sp1 = test.spliterator();
//        Spliterator<Integer> sp2 = sp1.trySplit();
//        Spliterator<Integer> sp3 = sp1.trySplit();
//        Spliterator<Integer> sp4 = sp2.trySplit();
//        sp1.forEachRemaining(System.out::println);
//        System.out.println("------->>>>>");
//        sp2.forEachRemaining(System.out::println);
//        System.out.println("------->>>>>");
//        sp3.forEachRemaining(System.out::println);
//        System.out.println("------->>>>>");
//        sp4.forEachRemaining(System.out::println);

        ForkJoinPool pool = new ForkJoinPool(MAX);
        pool.submit(() ->
                test.parallelStream()
                        .forEach(i -> {
                            System.out.println("Start:" + Thread.currentThread().getId() + ":" + i);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                            }
                            System.out.println("Finish:" + Thread.currentThread().getId() + ":" + i);
                        })).get();
        System.out.println("FINISH");

    }
}
