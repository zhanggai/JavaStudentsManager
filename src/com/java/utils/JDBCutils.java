package com.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Description:To load JDBC driver</p>
 *
 * @author XuDing
 * @version 1.0
 */
public class JDBCutils
{
    //define username and password of database
    private final String USERNAME = "admin";
    private final String PASSWORD = "123456";
    //define the Driver information
    private final String DRIVER = "com.mysql.jdbc.Driver";
    //define the url of database
    private final String DBURL = "jdbc:mysql://localhost:3306/students";
    //define the connection
    private Connection connection;
    //define the sql pre statement
    private PreparedStatement prestmt;
    //define the result set
    private ResultSet resultset;

    public JDBCutils()
    {
        try
        {
            //load the driver
            Class.forName(DRIVER);
            System.out.println("注册驱动成功");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        JDBCutils dbutil = new JDBCutils();
        dbutil.getConnection();
        String sql = "insert into information(姓名,性别,籍贯,出生年月) values(?,?,?,?)";
        List<Object> values = new ArrayList<>();

        values.add("徐鼎");
        values.add("男");
        values.add("新疆维吾尔族自治区");
        values.add("1996-05-06");

        try
        {
            boolean flag = dbutil.updateByPrepareStatement(sql, values);
            System.out.println(flag);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        try
        {
            //connect to database
            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("连接数据库成功");
        return connection;
    }

    /**
     * @param sql   the sql statement prepared to act
     * @param value the value prepared to change
     * @return if the line quantity be changed > 0
     * @throws SQLException
     */
    public boolean updateByPrepareStatement(String sql, List<Object> value) throws SQLException
    {
        prestmt = connection.prepareStatement(sql);
        int index = 1;
        if (value != null && !value.isEmpty())
        {

            for (Object aValue : value)
            {
                prestmt.setObject(index++, aValue);
            }

        }
        return prestmt.executeUpdate() > 0;
    }
}
