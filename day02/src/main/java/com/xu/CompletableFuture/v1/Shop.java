package com.xu.CompletableFuture.v1;

import com.xu.CompletableFuture.Util;
import lombok.Data;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author xudenghui
 * @create 2020-12-18 10:27
 **/
@Data
public class Shop {

    private final String name;
    private final Random random;

    public Shop(String name) {
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public double getPrice(String product){
        return  calculatePrice(product);
    }

    public Future<Double> getPriceAsyc(String product){
       /* CompletableFuture<Double> future = new CompletableFuture<>();
        new Thread(()->{
            try{
                double price = calculatePrice(product);
                future.complete(price);
            }catch (Exception ex){
                future.completeExceptionally(ex);
            }

        }).start();
        return  future;*/

        return  CompletableFuture.supplyAsync(()->calculatePrice(product));
    }

    private double calculatePrice(String product) {
        Util.delay();
        return random.nextDouble()*product.charAt(0)+product.charAt(1);
    }



}
