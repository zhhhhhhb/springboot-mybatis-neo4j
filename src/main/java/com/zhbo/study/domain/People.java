package com.zhbo.study.domain;

/**
 * @author zhengbo
 * @date 2020/10/15 14:00
 */
public class People {

    /**名字*/
    protected String name;

    /**年龄*/
    protected Long age;

    /**性别*/
    protected String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
