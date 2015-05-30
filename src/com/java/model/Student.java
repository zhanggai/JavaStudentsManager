package com.java.model;

import java.io.Serializable;

/**
 * <p>
 * Description:Students
 * </p>
 *
 * @author XuDing
 * @version 1.0
 * @date 2015/4/21
 */
public class Student implements Serializable
{

    //	设置序列化id防止随着jdk的版本变化而出现异常
    private static final long serialVersionUID = 1L;

    private String name;
    private String birthday;
    private String nativePlace;
    private String id;
    private String sex;

    public Student()
    {
        this("2014011176", "王晓明", "男", "河北", "1996.1.1");
    }

    public Student(String id, String name, String sex, String nativePlace, String birthday)
    {
        this.name = name;
        this.birthday = birthday;
        this.nativePlace = nativePlace;
        this.id = id;
        this.sex = sex;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", nativePlace='" + nativePlace + '\'' +
                ", id='" + id + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Object[] getData()
    {
        return new Object[]{getId(), getName(), getSex(), getNativePlace(), getBirthday()};
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getNativePlace()
    {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace)
    {
        this.nativePlace = nativePlace;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }
}
