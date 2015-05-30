package com.java.utils;

import com.java.model.Student;

import java.lang.reflect.Field;
import java.sql.*;
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
        getConnection();
    }

    /* public static void main(String[] args)
     {
         //JDBCutils.getData();


   //                      利用反射机制查询一条记录
         *//*        String sql = "select * from student where id = ? ";
                    List<Object> values = new ArrayList<>();
                    values.add(2014011003);

                    try
                    {
                        System.out.println(dbutil.findSimpleRefResult(sql, values, Information.class));
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }*//*
        }*/
    //删除数据表中的一条学生数据
    public static void deleteAStudent(String id) {
        JDBCutils dbutil = new JDBCutils();
        String sql = "delete from student where id=?";
        List<Object> values = new ArrayList<>();
        values.add(id);
        try {
            dbutil.deteleByPrepareStatement(sql, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //增加一名学生的信息到数据表
    public static void addAStudent(String id, String name, String sex, String nativePlace, String birth) {
        JDBCutils dbutil = new JDBCutils();
        String sql = "insert into student(id,name,sex,nativePlace,birthday) values(?,?,?,?,?)";
        List<Object> values = new ArrayList<>();
        values.add(id);
        values.add(name);
        values.add(sex);
        values.add(nativePlace);
        values.add(birth);

        try {
            dbutil.updateByPrepareStatement(sql, values);
            System.out.println("添加到数据库成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //以存放了Student对象的List的形式返回数据表中的所有数据
    public static List<Student> getData() {
        JDBCutils dbutil = new JDBCutils();
        List<Student> list = null;
        String sql = "select * from student";
        try
        {
            list = dbutil.findMoreRefResult(sql, null, Student.class);
        } catch (Exception e)
        {
            // TODO: handle exception
        } finally {
            dbutil.closeConnection();
        }
        return list;
    }

    /**
     * @return 获得数据库的连接
     */
    public Connection getConnection() {
        try
        {
//            注册驱动
            connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("连接数据库成功");
        return connection;
    }

    public void closeConnection() {
        if (resultset != null)
        {
            try {
//                关闭结果集合连接
                resultset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (prestmt != null) {
            try {
//                关闭MySQL执行语句连接
                prestmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
//                关闭数据库连接
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public <T> List<T> findMoreRefResult(String sql, List<Object> value, Class<T> cls) throws Exception {
        List<T> list = new ArrayList<T>();
        int index = 1;
        prestmt = connection.prepareStatement(sql);
        if (value != null && !value.isEmpty())
        {
            for (Object aValue : value)
            {
                prestmt.setObject(index++, aValue);
            }
        }
        resultset = prestmt.executeQuery();

        ResultSetMetaData metaData = resultset.getMetaData();
        int cols_len = metaData.getColumnCount();

        while (resultset.next())
        {

            T resultObject = cls.newInstance();

            for (int i = 0; i < cols_len; i++)
            {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = resultset.getObject(cols_name);
                if (cols_value == null)
                {
                    cols_value = "";
                }

                Field field = cls.getDeclaredField(cols_name);

                field.setAccessible(true);
                try
                {
                    field.set(resultObject, cols_value);
                } catch (IllegalArgumentException e)
                {
                    //TODO
                }

            }
            list.add(resultObject);

        }
        return list;
    }

    public boolean updateByPrepareStatement(String sql, List<Object> value) throws SQLException {
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

    public void deteleByPrepareStatement(String sql, List<Object> value) throws SQLException {
        prestmt = connection.prepareStatement(sql);
        int index = 1;
        if (value != null && !value.isEmpty())
        {
            for (Object aValue : value)
            {
                prestmt.setObject(index++, aValue);
            }

        }
        prestmt.execute();
    }

    public <T> T findSimpleRefResult(String sql, List<Object> value, Class<T> cls) throws Exception {
        T resultObject = null;
        int index = 1;
        prestmt = connection.prepareStatement(sql);
        if (value != null && !value.isEmpty())
        {
            for (Object aValue : value)
            {
                prestmt.setObject(index++, aValue);
            }
        }
        resultset = prestmt.executeQuery();
        ResultSetMetaData metaData = resultset.getMetaData();
        int cols_len = metaData.getColumnCount();
        while (resultset.next())
        {
            // 通过反射机制创建实例
            resultObject = cls.newInstance();
            for (int i = 0; i < cols_len; i++)
            {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = resultset.getObject(cols_name);
                if (cols_value == null)
                {
                    cols_value = "";
                }
                Field field = cls.getDeclaredField(cols_name);
                field.setAccessible(true);// 打开javabean的访问private权限
                try
                {
                    field.set(resultObject, cols_value);
                } catch (IllegalArgumentException e)
                {
                    System.out.println(e);
                }
            }
        }
        return resultObject;
    }
}
