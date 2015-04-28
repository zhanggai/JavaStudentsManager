package com.java.Data;

import com.java.model.Student;

import java.util.ArrayList;

/**
 * <p>
 * Description: save the data of students.
 * </p>
 *
 * @author XuDing
 * @version 1.0
 */
public class Data extends ArrayList<Student>
{// 单例模式，只操作一个对象
    private static Data data = null;

    private Data()
    {
        initData();
    }

    public void initData()
    {
        add(new Student("2014011171", "王XX", "男", "北京", "1994.05.01"));
        add(new Student("2014011172", "周XX", "男", "河北", "1996.01.18"));
        add(new Student("2014011145", "赵XX", "男", "北京", "1994.08.13"));
        add(new Student("2014011172", "孙XX", "男", "北京", "1997.02.11"));
        add(new Student("2014011135", "王XX", "男", "北京", "1995.09.30"));
        add(new Student("2014011176", "周XX", "男", "河北", "1996.01.18"));
        add(new Student("2014011171", "刘XX", "男", "北京", "1996.12.01"));
        add(new Student("2014011135", "王XX", "男", "北京", "1995.09.30"));
        add(new Student("2014011150", "徐XX", "男", "北京", "1996.02.25"));
        add(new Student("2014011175", "王XX", "男", "北京", "1995.09.30"));
        add(new Student("2014011174", "李XX", "男", "广州", "1996.04.08"));
        add(new Student("2014011105", "王XX", "男", "北京", "1995.09.30"));
        add(new Student("2014011185", "王XX", "男", "北京", "1995.09.30"));
        add(new Student("2014011195", "王XX", "男", "北京", "1995.09.30"));
        add(new Student("2014011173", "王XX", "男", "北京", "1994.05.01"));
        add(new Student("2014011174", "李XX", "男", "广州", "1996.04.08"));
        add(new Student("2014011186", "郑XX", "男", "福建", "1996.01.18"));

    }

    public static Data getData()
    {
        if (data == null)
        {
            data = new Data();
        }
        return data;
    }

}
