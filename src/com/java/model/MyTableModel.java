package com.java.model;

import com.java.data.Data;

import javax.swing.table.AbstractTableModel;
/**
 * <p>Description: a table model</p>
 *
 * @author XuDing
 * @version 1.0
 */
public class MyTableModel extends AbstractTableModel
{

    String[] columnNames = {"学号", "姓名", "性别", "籍贯", "生日"};
    Data studentsData = Data.getData();

    // get the number of rows
    @Override
    public int getRowCount()
    {
        return studentsData.size();
    }

    // get the number of cols
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    // get the value of the location
    @Override
    public Object getValueAt(int rows, int cols)
    {
        return studentsData.get(rows).getData()[cols];
    }

    // get the col's name
    public String getColumnName(int col)
    {
        return columnNames[col];
    }

    // set the first col be unmodified
    public boolean isCellEditable(int row, int col)
    {
        return col != 0;
    }//col == 0 ? false : true

    //set the value of what you are editing.
    public void setValueAt(Object value, int row, int col)
    {
        Student student = studentsData.get(row);
        switch (col)
        {
            case 0:
                student.setId((String) value);
                break;
            case 1:
                student.setName((String) value);
                break;
            case 2:
                student.setSex((String) value);
                break;
            case 3:
                student.setNativePlace((String) value);
                break;
            case 4:
                student.setBirthday((String) value);
                break;
            default:
                break;
        }
    }

}
