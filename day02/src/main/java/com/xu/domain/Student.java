package com.xu.domain;

import lombok.Data;

/**
 * @author xudenghui
 * @create 2020-12-14 15:00
 **/
@Data
public class Student extends Person{
    //学号
    private String snum;
    // 学院
    private String scoll;
    // 班级
    private String sclass;
}
