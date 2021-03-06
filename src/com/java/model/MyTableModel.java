package com.java.model;

import com.java.utils.ConfirmInput;
import com.java.utils.JDBCutils;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * 重写的AbstractTableModel类，显示一个表格所必须的类
 */

public class MyTableModel extends AbstractTableModel {
    //获得数据库中的所有学生信息
    public static List<Student> studentsData = JDBCutils.getAllStudent();
    //  用数组放置要显示出来的列名
    String[] columnNames = {"学号", "姓名", "性别", "籍贯", "生日"};

    /**
     * @return 返回已经存储的学生信息个数
     */
    @Override
    public int getRowCount() {
        return studentsData.size();
    }

    /**
     * @return 返回列的列的数量
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * @param rows 正在编辑的行号
     * @param cols 正在编辑的列号
     * @return 获得正在编辑的某个单元格的内容
     */
    @Override
    public Object getValueAt(int rows, int cols) {
        return studentsData.get(rows).getData()[cols];
    }

    /**
     * @param col 要获得列名所在的列号
     * @return 获得列名
     */
    public String getColumnName(int col) {
        return columnNames[col];
    }


    /**
     * 设置某一列（学号）不可编辑
     *
     * @param row 要设置不可编辑的单元格行号
     * @param col 要设置不可编辑的单元格列号
     * @return 如果为第一列返回false
     */
    public boolean isCellEditable(int row, int col) {
        //col == 0 ? false : true
        return col != 0;
    }


    /**
     * 把正在编辑的单元格的值设置为新值
     *
     * @param value 在单元格中输入的值
     * @param row   该单元格的行
     * @param col   该单元格的列
     */
    public void setValueAt(Object value, int row, int col) {
        Student student = MyTableModel.studentsData.get(row);
        switch (col) {
            case 1:
                if (ConfirmInput.checkInput("2014011175", (String) value, "男", "安徽", "19960621")) {
                    student.setName((String) value);//设置显示出来的值为value
                    JDBCutils.modifiedAStudent("name", (String) value, student.getId());//把数据中name列，学号为getId的值设置为value
                }

                break;
            case 2:
                if (ConfirmInput.checkInput("2014011175", "徐鼎", (String) value, "安徽", "19960621")) {
                    student.setSex((String) value);
                    JDBCutils.modifiedAStudent("sex", (String) value, student.getId());
                }
                break;
            case 3:
                if (ConfirmInput.checkInput("2014011175", "徐鼎", "男", (String) value, "19960621")) {
                    student.setNativePlace((String) value);
                    JDBCutils.modifiedAStudent("nativePlace", (String) value, student.getId());
                }
                break;
            case 4:
                if (ConfirmInput.checkInput("2014011175", "徐鼎", "男", "安徽", (String) value)) {
                    student.setBirthday((String) value);
                    JDBCutils.modifiedAStudent("birthday", (String) value, student.getId());
                }
                break;
            default:
                break;
        }
    }

}
