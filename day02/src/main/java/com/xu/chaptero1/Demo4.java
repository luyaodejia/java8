package com.xu.chaptero1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xudenghui
 * @create 2021-01-04 14:56
 **/
public class Demo4 {
  public static void main(String[] args) {
      List<User> userList = new ArrayList<>();
      userList.add(new User(1, "aaa"));
      userList.add(new User(2, "bbb"));
      userList.add(new User(3, "ccc"));
      userList.add(new User(2, "ddd"));
      userList.add(new User(3, "eee"));
    Map<Integer, User> collect =
        userList.stream()
            .collect(
                Collectors.toMap(
                    User::getA,
                        Function.identity(),
                    (a1, a2) -> {
                       if ( a1.getA()>a2.getA()){
                        return null;
                       }else{
                           return a1;
                       }


                    }));
    System.out.println(collect);
  }


}

@Data
class User{
    int a;
    String b;

    public User(int a, String b) {
        this.a=a;
        this.b=b;
    }
}