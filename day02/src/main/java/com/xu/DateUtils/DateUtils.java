package com.xu.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 获取最近十二月
 *
 * @author xudenghui
 * @create 2021-01-06 11:50
 **/
public class DateUtils {
    public static void main(String[] args){
        List<String> initMonthMapWithZero = getInitMonthMapWithZero();

    }

  private static List<String> getInitMonthMapWithZero() {
    List<String> list = new ArrayList<String>();
    Calendar c = Calendar.getInstance();
    for (int i = 0; i < 12; i++) {
      int k = c.get(Calendar.YEAR);
      int j = c.get(Calendar.MONTH) + 1 - i;
      String date = "";
      if (j >= 1) {
        date = k + "-" + (j >= 10 ? "" : "0") + j;
      } else {
        int p = 11 - i; // 剩余循环次数
        int m = c.get(Calendar.YEAR) - 1;
        int n = c.get(Calendar.MONTH) + 2 + p;
        date = m + "-" + (n >= 10 ? "" : "0") + n;
      }
      list.add(date);
    }
    return list;
    }

 }
