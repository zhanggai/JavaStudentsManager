package com.java.windows;

import com.java.model.MyButton;
import com.java.model.MyTableModel;
import com.java.model.MyWindow;
import com.java.utils.JDBCutils;
import com.java.utils.WindowCache;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * 显示学生数据表的界面
 */

public class ShowStudent extends MyWindow {
    public ShowStudent() {
        initialWindow("学生信息", "学生信息", new int[]{238, 10, 173, 45});
        JTable table = new JTable(new MyTableModel());//将重写的TableModel加载到Jtable里以显示数据
        initPane(table);
        initButton(table);
    }

    public void initPane(JTable table) {
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);//当数据超过表的高度时，将超出表格高度的数据隐藏到表的下层，只有拖动侧栏才会出现
        scrollPane.setBounds(10, 86, 614, 240);
        contentPane.add(scrollPane);

    }

    public void initButton(JTable table) {
        MyButton button_add = new MyButton("添加学生", 15, 130, 364, 95, 23);
        button_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    WindowCache.showWindow("add_student");
                    setVisible(false);
                }
            }
        });
        contentPane.add(button_add);

        MyButton button_refresh = new MyButton("取消选中", 15, 230, 364, 95, 23);
        button_refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();
                table.updateUI();
            }

        });
        contentPane.add(button_refresh);

        MyButton button_delete = new MyButton("删除选中", 15, 330, 364, 95, 23);
        button_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (table.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "没有选中项！！");
                } else {
                    int r = JOptionPane.showConfirmDialog(null, "删除后不可恢复，你确定要删除吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                    if (r == 0) {
                        String toDeleteId = MyTableModel.studentsData.get(table.getSelectedRow()).getId();
                        JDBCutils.deleteAStudent(toDeleteId);
                        MyTableModel.studentsData.remove(table.getSelectedRow());
                        table.updateUI();
                    }
                }
            }
        });
        contentPane.add(button_delete);

        MyButton button_logout = new MyButton("注销账户", 15, 430, 364, 95, 23);
        button_logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowCache.showWindow("login");
                setVisible(false);
                try {
//                    关闭数据库连接
                    JDBCutils.connection.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
        });
        contentPane.add(button_logout);
    }
}


