package com.xu.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 异步计算
 * @author xudenghui
 * @create 2020-12-18 8:54
 **/
public class ExecutorDemo1 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
     ExecutorService service = Executors.newSingleThreadExecutor();
     Future<Integer> future= service.submit(()->{
          try {
              Thread.sleep(5);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          return 1;
      });
    System.out.println(future.get());
  }
}
