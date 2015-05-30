package com.java.utils;

import com.java.model.MyDialog;

import java.sql.SQLException;

/**
 * 用于对输入进行验证
 *
 * @author XuDing
 * @version 1.0
 * @date 2015/5/30
 */
public class ConfirmInput
{
    // 使用正则表达式对输入进行验证
    public static boolean checkInput(String num, String name, String sex, String location, String birth)
    {
        boolean flag = false;
        if (!num.matches("[0-9]{10}"))
        {
            MyDialog.show("学号为10位数字！");
        } else try
        {
            if (JDBCutils.confirmRepeat(num))
            {
                MyDialog.show("该学号已经存在！");
            } else if (!name.matches("[\\u4E00-\\u9FA5]{2,4}"))
            {
                MyDialog.show("请填写正确的姓名！");
            } else if (!sex.matches("[男|女]"))
            {
                MyDialog.show("请输入正确性别");
            } else if (!location.matches("[\\u4E00-\\u9FA5]{2,5}"))
            {
                MyDialog.show("请填写正确的籍贯！");
            } else if (!birth.matches("19[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"))
            {
                MyDialog.show("请填写正确的出生年月！如19960101");
            } else flag = true;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return flag;
    }
}
