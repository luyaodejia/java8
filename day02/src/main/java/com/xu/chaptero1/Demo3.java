package com.xu.chaptero1;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xudenghui
 * @create 2020-12-25 19:29
 **/
public class Demo3 {
  public static void main(String[] args) {
//      List<String> destList = new ArrayList<>(Arrays.asList("foo"));
//      List<String> newList = Arrays.asList("0", "1", "2", "3", "4", "5");
//    System.out.println(newList);
//      List<String> destList1 =
//              Collections.synchronizedList(new ArrayList<>(Arrays.asList("foo")));
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date(1611214837000L);
    System.out.println(sdf.format(date));
  }
}
