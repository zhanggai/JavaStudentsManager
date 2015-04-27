package com.java.model;

import com.java.Data.Data;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel
{


    String[] columnNames = {"学号", "姓名", "性别", "籍贯", "生日"};
    Data studentsData = Data.getData();

    public MyTableModel()
    {
    }

    public MyTableModel(Student student)
    {
        studentsData.add(student);
    }

    // 设置列数
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    // 设置行数
    @Override
    public int getRowCount()
    {
        return studentsData.size();
    }

    // 填充数据
    @Override
    public Object getValueAt(int rows, int cols)
    {
        return studentsData.get(rows).getData()[cols];
    }

    // 显示列名
    public String getColumnName(int col)
    {
        return columnNames[col];
    }

    // 设置第一列不可编辑
    public boolean isCellEditable(int row, int col)
    {
        return col != 0;
    }//col == 0 ? false : true

    public void setValueAt(Object value, int row, int col)
    {
        Student s = studentsData.get(row);
        switch (col)
        {
            case 0:
                s.setId((String) value);
                break;
            case 1:
                s.setName((String) value);
                break;
            case 2:
                s.setSex((String) value);
                break;
            case 3:
                s.setNativePlace((String) value);
                break;
            case 4:
                s.setBirthday((String) value);
                break;
            default:
                break;
        }
    }


}
