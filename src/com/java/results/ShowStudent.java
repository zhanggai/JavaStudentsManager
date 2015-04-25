package com.java.results;

import com.java.model.Student;

/**
 * <p>Description: Show any item of student.</p>
 *
 * @author XuDing
 * @version 1.0
 * @date 2015/4/21
 */
public class ShowStudent
{
    public static String showName(Student student)
    {
        return student.getName();
    }

    public static String showId(Student student)
    {
        return student.getId();
    }

    public static String showSex(Student student)
    {
        return student.getSex();
    }

    public static String showNativePlace(Student student)
    {
        return student.getNativePlace();
    }

    public static String showBirthday(Student student)
    {
        return student.getBirthday();
    }
}
