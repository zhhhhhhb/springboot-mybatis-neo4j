package com.zhbo.study.domain;

/**
 * @author zhengbo
 * @date 2020/10/15 13:56
 * 学生
 */
public class Student extends People {

    /**学生id*/
    private String sId;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
