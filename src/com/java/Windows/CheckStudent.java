package com.java.windows;

import com.java.data.Data;
import com.java.model.MyButton;
import com.java.model.MyTableModel;
import com.java.model.MyWindow;
import com.java.utils.WindowCache;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CheckStudent extends MyWindow
{
    Data studentData = Data.getData();

    public CheckStudent()
    {
        initialWindow("学生信息", "学生信息", new int[]{238, 10, 173, 45});
        JTable table = new JTable(new MyTableModel());
        table.setAutoCreateRowSorter(true);//添加排序功能
        initPane(table);
        initButton(table);
    }

    public void initPane(JTable table)
    {
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);//while the data are over the height of pane,make it hide in the underside
        scrollPane.setBounds(10, 86, 614, 240);
        contentPane.add(scrollPane);

    }

    public void initButton(JTable table)
    {
        MyButton button_import = new MyButton("导入数据", 15, 510, 55, 100, 21);
        button_import.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                studentData.initData();
                table.updateUI();
            }
        });
        contentPane.add(button_import);

        MyButton button_add = new MyButton("添加学生", 15, 130, 364, 95, 23);
        button_add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                {
                    WindowCache.showWindow("add_student");
                    setVisible(false);
                }
            }
        });
        contentPane.add(button_add);

        MyButton button_refresh = new MyButton("刷新表格", 15, 230, 364, 95, 23);
        button_refresh.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                table.clearSelection();
                table.updateUI();
            }

        });
        contentPane.add(button_refresh);

        MyButton button_delete = new MyButton("删除选中", 15, 330, 364, 95, 23);
        button_delete.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (table.getSelectedRow() == -1)
                {
                    JOptionPane.showMessageDialog(null, "没有选中项！！");
                } else
                {
                    int r = JOptionPane.showConfirmDialog(null, "删除后不可恢复，你确定要删除吗？", "确认删除", JOptionPane.YES_NO_OPTION);
                    if (r == 0)
                    {
                        // return the number of the field your selected.
                        studentData.remove(table.getSelectedRow());
                        // refresh
                        table.updateUI();
                    }
                }
            }
        });
        contentPane.add(button_delete);

        MyButton button_logout = new MyButton("注销账户", 15, 430, 364, 95, 23);
        button_logout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                WindowCache.showWindow("login");
                setVisible(false);
            }
        });
        contentPane.add(button_logout);
    }
}
