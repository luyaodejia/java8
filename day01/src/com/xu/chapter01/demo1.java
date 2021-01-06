package com.xu.chapter01;

/**
 * @author xudenghui
 * @create 2020-12-11 19:40
 **/
public class demo1 {
  public static void main(String[] args) {
    //实现 formula
    Formula formula=  new Formula(){
      @Override
      public double calculate(int a) {
        return sqrt(a*100);
      }
    };
    System.out.println(formula.calculate(4));
    System.out.println( formula.sqrt(6));


  }
}
