package com.test.xu;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.Optional;

/**
 * @author xudenghui
 * @create 2021-01-12 10:29
 **/
@Slf4j
public class Test1 {

    @Test
    public void test() throws Exception {
        User user=null;
        //   java.lang.NullPointerException
        //  Assert.assertEquals(Optional.of(user).orElse(createUser()),null);
        //Optional.ofNullable(user).orElse(createUser());

        //Optional.ofNullable(user).orElseThrow(()->new Exception("用户名不存在"));
        user=Optional.ofNullable(user).orElseGet(()->createUser());
        String city = Optional.ofNullable(user).map(u -> u.getName()).get();
        log.info(city);
    }

    /**
     * isPresent()和ifPresent(Consumer<? super T> consumer)
     * isPresent 判断value值是否为空
     * ifPresent 就是在不为空的时候,做一些操作
     *
     */
    @Test
    public void test2(){
        User user=null;
        //user=Optional.ofNullable(user).orElseGet(()->createUser());
        Optional.ofNullable(user).ifPresent(u->{
            log.info("do some thing .....");
        });
    }

    /**
     * Optional 实战
     * java8以前
     * java8
     */
    @Test
    public void test3() throws Exception {
        User user=null;
        user=Optional.ofNullable(user).orElseGet(()->createUser());
        System.out.println(getCity(user));
        System.out.println(getCity8(user));
    }

    /**
     * java8 写法
     */
    private String getCity8(User user) throws Exception {
        return Optional.ofNullable(user).map(u->u.getAddress()).map(a->a.getCity()).orElseThrow(()->new Exception("取值错误"));
    }

    /**
     * java8以前写法
     */
    private String  getCity(User user) throws Exception {
        if (user!=null){
            if (user.getAddress()!=null){
                Address address = user.getAddress();
                if (address.getCity()!=null){
                    return address.getCity();
                }
            }
        }
        throw new Exception("取值错误");
    }


    /**
     *
     * @return
     */
    public User createUser(){
        log.info("进入createUser方法: {}",System.currentTimeMillis());
        User user = new User();
        user.setName("张三");
        Address address=new Address();
        address.setCity("长沙");
        user.setAddress(address);
        return user;
    }


    @Data
   class    User{
        private String name;
        private Address address;
   }

   @Data
   class Address{
        private String city;

   }
}

