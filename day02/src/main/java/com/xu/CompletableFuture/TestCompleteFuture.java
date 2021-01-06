package com.xu.CompletableFuture;

import java.util.concurrent.CompletableFuture;

/**
 * @author xudenghui
 * @create 2020-12-18 14:34
 **/
public class TestCompleteFuture {
  public static void main(String[] args) {

      String result = CompletableFuture.supplyAsync(()->{
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          return "hello";
      }).thenCombine(CompletableFuture.supplyAsync(()->{
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          return "world";
      }),(s1,s2)->{return  s1+" "+s2;}).thenApply(v->v+" world").join();
    System.out.println(result);
  }
}
