package com.java.model;

/**
 * <p>Description:Students </p>
 *
 * @author XuDing
 * @version 1.0
 * @date 2015/4/21
 */
public class Student
{
    private String name;
    private String birthday;
    private String nativePlace;
    private String id;
    private String sex;


    /*constructor*/
    public Student()
    {
        this(null, null, null, null, null);
    }

    public Student(String name, String birthday, String nativePlace, String id, String sex)
    {
        this.name = name;
        this.birthday = birthday;
        this.nativePlace = nativePlace;
        this.id = id;
        this.sex = sex;
    }

    public static void main(String[] args)
    {
        System.out.println(new Student());
    }

    /*getter and setter*/
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getNativePlace()
    {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace)
    {
        this.nativePlace = nativePlace;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    /*toString*/
    @Override
    public String toString()
    {
        return "name=" + name +
                ", birthday=" + birthday +
                ", nativePlace=" + nativePlace +
                ", id=" + id +
                ", sex=" + sex;
    }
}
