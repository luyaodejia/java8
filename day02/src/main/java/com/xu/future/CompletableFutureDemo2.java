package com.xu.future;


import java.util.concurrent.CompletableFuture;

/**
 * @author xudenghui
 * @create 2020-12-18 9:22
 **/
public class CompletableFutureDemo2 {
  public static void main(String[] args) throws InterruptedException {
        getRemainingQuantity();

  }

    static Double fetchPrice() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random()<0.3){
            throw new RuntimeException("Fetch price failed! ");
        }
        return 5+Math.random()*20;
    }

    private static void  getRemainingQuantity() throws InterruptedException {
        //创建异步执行任务
        CompletableFuture<Double> cf = CompletableFuture.supplyAsync(CompletableFutureDemo2::fetchPrice);
        //如果执行成功
        cf.thenAccept((result)->{
            System.out.println("price:"+result);
        });

        //如果执行异常
        cf.exceptionally((e)->{
            e.printStackTrace();
            return null;
        });
        //主线程不要立刻结束,否则CompletableFuturae默认使用线程池会立刻关闭
        Thread.sleep(2000);
    }




}
