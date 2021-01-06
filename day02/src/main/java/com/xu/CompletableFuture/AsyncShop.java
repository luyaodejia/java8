package com.xu.CompletableFuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author xudenghui
 * @create 2020-12-18 10:37
 **/
public class AsyncShop {
    private final String name;
    private final Random random;

    public AsyncShop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public Future<Double> getPriceAsyc(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(()->{
            double price = calculatePrice(product);
            future.complete(price);
        }).start();
        return  future;
    }

    private double calculatePrice(String product) {
        Util.delay();
        return random.nextDouble()*product.charAt(0)+product.charAt(1);
    }
}
