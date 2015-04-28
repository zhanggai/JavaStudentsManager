package com.java.Windows;

import com.java.Container.WindowCache;
import com.java.Data.Data;
import com.java.model.MyButton;
import com.java.model.MyLabel;
import com.java.model.MyTextField;
import com.java.model.MyWindow;
import com.java.model.Student;

public class AddStudent extends MyWindow
{
    public AddStudent()
    {
        initialWindow("添加学生信息", "添加学生信息", new int[]{192, 24, 279, 55});

        contentPane.add(new MyLabel("学号：", 120));
        contentPane.add(new MyLabel("姓名：", 170));
        contentPane.add(new MyLabel("性别：", 220));
        contentPane.add(new MyLabel("籍贯：", 270));
        contentPane.add(new MyLabel("生日：", 320));
        MyTextField num_field = new MyTextField(120);
        MyTextField name_field = new MyTextField(170);
        MyTextField sex_field = new MyTextField(220);
        MyTextField location_field = new MyTextField(270);
        MyTextField birth_field = new MyTextField(320);
        contentPane.add(num_field);
        contentPane.add(name_field);
        contentPane.add(sex_field);
        contentPane.add(location_field);
        contentPane.add(birth_field);

        MyButton button_ensure = new MyButton("确定", 18, 242, 371, 81, 30);

        button_ensure.addActionListener(e -> {
            Student student = new Student(num_field.getText(), name_field.getText(), sex_field.getText(), location_field.getText(), birth_field.getText());
            Data.getData().add(student);
            WindowCache.showWindow("check_student");
            setVisible(false);
        });
        contentPane.add(button_ensure);

        MyButton button_cancel = new MyButton("取消", 18, 358, 371, 81, 30);

        button_cancel.addActionListener(e -> {
            WindowCache.showWindow("home_page");
            setVisible(false);
        });
        contentPane.add(button_cancel);

    }
}
