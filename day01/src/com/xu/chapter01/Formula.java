package com.xu.chapter01;

/**
 * @author xudenghui
 * @create 2020-12-11 21:09
 **/
public interface Formula {
    double calculate(int a);

    default  double sqrt(int a){
        return Math.sqrt(a);
    }
}
