package com.zhbo.study.domain;

/**
 * @author zhengbo
 * @date 2020/10/15 13:58
 * 老师
 */
public class Teacher extends People {

    /**老师id*/
    private String tId;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tId='" + tId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
