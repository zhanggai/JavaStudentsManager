package com.java.model;

import java.io.Serializable;

/**
 * 描述学生的类,同时这个学生类的属性与数据库中的数据表列名一致
 *
 * @author XuDing
 * @version 1.0
 * @date 2015/4/21
 */

//为了连接数据库，使该类实现可序化
public class Student implements Serializable {

    //	设置序列化id防止随着jdk的版本变化而出现异常
    private static final long serialVersionUID = 1L;

    private String name;
    private String birthday;
    private String nativePlace;
    private String id;
    private String sex;

    public Student() {
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    //    获把这个对象的所有属性放进一个数组
    public Object[] getData() {
        return new Object[]{getId(), getName(), getSex(), getNativePlace(), getBirthday()};
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
