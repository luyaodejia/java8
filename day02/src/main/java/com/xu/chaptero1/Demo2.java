package com.xu.chaptero1;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @author xudenghui
 * @create 2020-12-15 18:19
 **/
public class Demo2 {
  public static void main(String[] args) {
    //
      Map<String, String> param = new HashMap<>();
      param.put("h12","吃饭");
      param.put("h123","读书");
      param.put("h124","干活");
      param.put("h125","撩妹");
      Map<String,String> h2 = new HashMap<>();
      h2.put("h12","fdsa");
      h2.put("h123","fdsa");
      h2.put("h124","fdsa");
      h2.put("h125","fdsa");

      Map<String,String> h3 = new HashMap<>();
      h3.put("h12","fdsa");
      h3.put("h12","fdsa1");
      h3.put("h12","fdsa2");
      h3.put("h12","fdsa3");

      List<Map<String,String>> list=new ArrayList<>();
      list.add(param);
      list.add(h2);
      list.add(h3);
 /*     Map<String, Object> resultMap = list
              .stream()
              .flatMap(map -> map.entrySet().stream())
              .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));

    System.out.println(resultMap);*/

     // list.stream().map(item->item.containsKey())





  }
}
