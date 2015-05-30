package com.java.windows;

import com.java.model.*;
import com.java.utils.ConfirmInput;
import com.java.utils.JDBCutils;
import com.java.utils.WindowCache;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 添加学生的界面
 */
public class AddStudent extends MyWindow {
    private String sex="无";

    public AddStudent() {
        initialWindow("添加学生信息", "添加学生信息", new int[]{192, 24, 279, 55});

        contentPane.add(new MyLabel("学号：", 120));
        contentPane.add(new MyLabel("姓名：", 170));
        contentPane.add(new MyLabel("性别：", 220));
        contentPane.add(new MyLabel("籍贯：", 270));
        contentPane.add(new MyLabel("生日：", 320));
        MyTextField num_field = new MyTextField(120);
        MyTextField name_field = new MyTextField(170);
        MyTextField location_field = new MyTextField(270);
        MyTextField birth_field = new MyTextField(320);
        MyButtonPanel button_panel = new MyButtonPanel(220);

        initButtonPanel(button_panel);

        contentPane.add(button_panel);
        contentPane.add(num_field);
        contentPane.add(name_field);
        contentPane.add(location_field);
        contentPane.add(birth_field);

        MyButton button_ensure = new MyButton("确定", 18, 242, 371, 81, 30);

        button_ensure.addActionListener(e -> {
            String num = num_field.getText();
            String name = name_field.getText();
            String location = location_field.getText();
            String birth = birth_field.getText();
            if (ConfirmInput.checkInput(num, name,sex, location, birth)) {

                JDBCutils.addAStudent(num, name, sex, location, birth);

                MyTableModel.studentsData.add(JDBCutils.getAStudent(num));
                WindowCache.showWindow("show_student");
                setVisible(false);

            }

        });
        contentPane.add(button_ensure);
        MyButton button_cancel = new MyButton("取消", 18, 358, 371, 81, 30);
        button_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowCache.showWindow("home_page");
                setVisible(false);
            }
        });
        contentPane.add(button_cancel);
    }

    //   初始化性别选项
    private void initButtonPanel(MyButtonPanel button_panel) {
        ButtonGroup radio_group = new ButtonGroup();
        JRadioButton male_button = new JRadioButton("男");
        JRadioButton female_button = new JRadioButton("女");
        button_panel.add(male_button);
        button_panel.add(female_button);
        radio_group.add(male_button);
        radio_group.add(female_button);

        male_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sex = "男";
            }
        });
        female_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sex = "女";
            }
        });
    }


}
