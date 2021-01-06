package com.xu.CompletableFuture.v1;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author xudenghui
 * @create 2020-12-18 11:12
 */
public class BestPriceFinder {
  private final List<Shop> shops =
      Arrays.asList(
          new Shop("BestPrice"),
          new Shop("LetsSaveBig"),
          new Shop("MyFavoriteShop"),
          new Shop("BuyItAll"),
          new Shop("BuyItAll1"),
          new Shop("BuyItAll2"),
          new Shop("BuyItAll3"),
          new Shop("BuyItAll4"),
          new Shop("BuyItAll5"),
          new Shop("ShopEasy"));

  public List<String> findPricesSequential(String product) {
    return shops.stream()
        .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
        .collect(Collectors.toList());
  }

  public List<String> findPricesParallel(String product) {
    return shops.parallelStream()
        .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
        .collect(Collectors.toList());
  }

  public List<String> findPricesFuture(String product) {
    List<CompletableFuture<String>> priceFutures =
        shops.stream()
            .map(
                shop ->
                    CompletableFuture.supplyAsync(
                        () ->
                            String.format(
                                "%s price is %.2f", shop.getName(), shop.getPrice(product))))
            .collect(Collectors.toList());
    List<String> prices =
        priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    return prices;
  }
}
