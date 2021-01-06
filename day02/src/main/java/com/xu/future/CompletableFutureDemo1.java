package com.xu.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xudenghui
 * @create 2020-12-18 9:06
 **/
public class CompletableFutureDemo1 {
  public static void main(String[] args) {
    String [] list={"a","b","c"};
    List<CompletableFuture> relist = new ArrayList<>();
    for(String str:list){
        relist.add(CompletableFuture.supplyAsync(()->str).thenApply(e->e.toUpperCase()));
    }
    System.out.println(relist);
    CompletableFuture.allOf(relist.toArray(new CompletableFuture[relist.size()])).whenComplete((r,e)->{
        if ((null==e)){

        }else {
            throw new RuntimeException(e);
        }
    });
  }
}
