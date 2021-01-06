package com.xu.CompletableFuture;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author xudenghui
 * @create 2020-12-18 13:39
 **/
public class BestPriceFinderMain {
    private static BestPriceFinder bestPriceFinder = new BestPriceFinder();

    public static void main(String[] args) {
        execute("sequential", () -> bestPriceFinder.findPricesSequential("myPhone27S"));
        execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhone27S"));
        execute("parallel", () -> bestPriceFinder.findPricesFuture("myPhone27S"));
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
