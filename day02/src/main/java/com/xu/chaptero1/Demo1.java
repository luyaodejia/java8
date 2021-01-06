package com.xu.chaptero1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xu.domain.Car;
import com.xu.domain.Student;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @author xudenghui
 * @create 2020-12-14 14:49
 **/
public class Demo1 {
  public static void main(String[] args) {
    Student student = new Student();
    student.setName("这是姓名");//父类中的属性
    student.setSnum("这是学号");
    Map maps = JSON.parseObject(JSON.toJSONString(student), Map.class);
    Map<String, Object> map = objToMap(maps,"name","snum");
    System.out.println(null == map.get("name"));//不是空
    System.out.println(null == map.get("age"));//是空的
    System.out.println(null == map.get("snum"));//不是空的
    System.out.println(null == map.get("scoll"));//是空的


  }


  //将对象转成map
  private static Map<String, Object> objToMap(Map maps,String ...shuxing) {
    Map<String, Object> map = new HashMap<String, Object>();
    Arrays.stream(shuxing)
        .filter(Objects::nonNull)
        .forEach(
            item -> {
              Object o1 = maps.get(item);
              if (o1 != null) {
                map.put(item,o1);
              }
            });
    return map;
  }










}
