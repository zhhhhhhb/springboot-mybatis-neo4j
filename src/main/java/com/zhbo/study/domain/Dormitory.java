package com.zhbo.study.domain;

import java.util.List;

/**
 * @author zhengbo
 * @date 2020/10/15 13:59
 * 宿舍
 */
public class Dormitory {

    /**寝室号*/
    private String roomNumber;

    /**学生们*/
    private List<Student> studentList;

    /**老师们*/
    private List<Teacher> teacherList;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "roomNumber='" + roomNumber + '\'' +
                ", studentList=" + studentList +
                ", teacherList=" + teacherList +
                '}';
    }
}
