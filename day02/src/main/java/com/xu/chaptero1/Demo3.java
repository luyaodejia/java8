package com.xu.chaptero1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xudenghui
 * @create 2020-12-25 19:29
 **/
public class Demo3 {
  public static void main(String[] args) {
      List<String> destList = new ArrayList<>(Arrays.asList("foo"));
      List<String> newList = Arrays.asList("0", "1", "2", "3", "4", "5");
      List<String> destList1 =
              Collections.synchronizedList(new ArrayList<>(Arrays.asList("foo")));

  }
}
