package com.java.Windows;

import com.java.Data.Data;
import com.java.model.MyWindow;
import com.java.model.Student;
import com.java.tools.WindowCache;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddStudent extends MyWindow
{

    /**
     * Create the frame.
     */
    public AddStudent()
    {
        initialWindow("添加学生信息", "添加学生信息", new int[]{192, 24, 279, 55});

        JLabel label_1 = new JLabel("学号：");
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_1.setBounds(175, 120, 66, 30);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("姓名：");
        label_2.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_2.setBounds(175, 170, 66, 30);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("性别：");
        label_3.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_3.setBounds(175, 220, 66, 30);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("籍贯：");
        label_4.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_4.setBounds(175, 270, 66, 30);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("生日：");
        label_5.setFont(new Font("微软雅黑", Font.PLAIN, 19));
        label_5.setBounds(175, 320, 66, 30);
        contentPane.add(label_5);

        JTextField textField = new JTextField();
        textField.setBounds(251, 120, 177, 29);
        contentPane.add(textField);
        textField.setColumns(10);

        JTextField textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(251, 170, 177, 29);
        contentPane.add(textField_1);

        JTextField textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(251, 220, 177, 29);
        contentPane.add(textField_2);

        JTextField textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(251, 270, 177, 29);
        contentPane.add(textField_3);

        JTextField textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(251, 320, 177, 29);
        contentPane.add(textField_4);

        JButton button = new JButton("确定");
        button.addActionListener(e -> {
            Student student = new Student(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText());
            Data.getData().add(student);
            WindowCache.showWindow("check_student");
            setVisible(false);
        });
        button.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button.setBounds(242, 371, 81, 30);
        contentPane.add(button);

        JButton button_1 = new JButton("取消");
        button_1.addActionListener(e -> {
            WindowCache.showWindow("home_page");
            setVisible(false);
        });
        button_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        button_1.setBounds(358, 371, 81, 30);
        contentPane.add(button_1);

    }
}
