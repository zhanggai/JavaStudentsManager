package com.experience.functions;


import com.experience.Data;
import com.experience.model.Student;

/**
 * <p>Description: function of adding students</p>
 *
 * @author XuDing
 * @version 1.0
 * @date 2015/4/21
 */
public abstract class AddStudents
{
    public static void addStudent(String name, String birthday, String nativePlace, String id, String sex)
    {
        Student student = new Student(name,birthday,nativePlace,id,sex);
        Data.studentList.add(student);
    }
}
