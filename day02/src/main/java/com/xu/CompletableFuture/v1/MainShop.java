package com.xu.CompletableFuture.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author xudenghui
 * @create 2020-12-18 10:44
 **/
public class MainShop {
  public static void main(String[] args) {
      Shop shop = new Shop("BestShop");
      long start = System.nanoTime();
      Future<Double> futurePrice = shop.getPriceAsyc("my favorite product");
      long invocationTime = ((System.nanoTime() - start) / 1_000_000);
      System.out.println("Invocation returned after " + invocationTime
              + " msecs");
      // Do some more tasks, like querying other shops
      doSomethingElse();
      // while the price of the product is being calculated
      try{
          Double price = futurePrice.get();
          System.out.printf("Price is %.2f%n", price);
      }catch (ExecutionException|InterruptedException e){
          throw new RuntimeException(e);
      }
      long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
      System.out.println("Price returned after " + retrievalTime + " msecs");

  }

    private static void doSomethingElse() {
        System.out.println("Doing something else...");
    }
}
