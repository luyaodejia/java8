package com.xu.CompletableFuture;

import com.xu.CompletableFuture.Shop;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.Collectors;

/**
 * @author xudenghui
 * @create 2020-12-18 12:01
 */
public class BestPriceFinder {

  private final List<Shop> shops =
      Arrays.asList(
          new Shop("BestPrice"),
          new Shop("LetsSaveBig"),
          new Shop("MyFavoriteShop"),
          new Shop("BuyItAll"),
          new Shop("ShopEasy"));

  private final Executor executor =
      Executors.newFixedThreadPool(
          shops.size(),
          new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
              Thread t = new Thread(r);
              t.setDaemon(true);
              return t;
            }
          });

  public List<String> findPricesSequential(String product) {
    return shops.stream()
        .map(shop -> shop.getPrice(product))
        .map(Quote::parse)
        .map(Discount::applyDiscount)
        .collect(Collectors.toList());
  }

  public List<String> findPricesParallel(String product) {
    return shops.parallelStream()
        .map(shop -> shop.getPrice(product))
        .map(Quote::parse)
        .map(Discount::applyDiscount)
        .collect(Collectors.toList());
  }

  public List<String> findPricesFuture(String product) {
  List<CompletableFuture<String>> priceFutures=  shops.stream()
        .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
        .map(future -> future.thenApply(Quote::parse))
        .map(
            future ->
                future.thenCompose(
                    quote ->
                        CompletableFuture.supplyAsync(
                            () -> Discount.applyDiscount(quote), executor)))
        .collect(Collectors.toList());

     return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
  }

/*
  public void  futurePriceINUSD(String product){
    shops.stream()
        .map(
            shop ->
                CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                    .thenCompose(
                        CompletableFuture.supplyAsync(
                            () ->
                                ExchangeService.getRate(
                                    ExchangeService.Money.EUR, ExchangeService.Money.USD)),(price,rate)->price * rate));
  }*/
}
