package com.java.utils;

import com.java.model.Information;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //    测试函数
    public static void main(String[] args)
    {
        JDBCutils dbutil = new JDBCutils();
        dbutil.getConnection();
        //                         利用反射机制查询多条记录
        String sql = "select * from information";
        try
        {
            List<Information> list = dbutil.findMoreRefResult(sql, null, Information.class);
            System.out.println(list);
        } catch (Exception e)
        {
            // TODO: handle exception
        } finally
        {
            dbutil.closeConnection();
        }

        //                利用反射机制查询一条记录
        //        String sql = "select * from information where id = ? ";
        //        List<Object> values = new ArrayList<>();
        //        values.add(2014011003);
        //
        //        try
        //        {
        //            System.out.println(dbutil.findSimpleRefResult(sql, values, Information.class));
        //        } catch (Exception e)
        //        {
        //            e.printStackTrace();
        //        }

        //          查询多条记录
        //                String sql = "select * from information";
        //                try
        //                {
        //                    List<HashMap<String, Object>> list=dbutil.findMoreResult(sql, null);
        //
        //                    System.out.println(list);
        //                } catch (SQLException e)
        //                {
        //                    e.printStackTrace();
        //                }finally
        //                {
        //                    dbutil.closeConnection();
        //                }

        //                查询一条记录
        //                String sql = "select * from information where 学号 = ? ";
        //                List<Object> values = new ArrayList<>();
        //                values.add(2014011005);
        //                try
        //                {
        //                    Map<String,Object> map=dbutil.findSimpleResult(sql, values);
        //                    System.out.println(map);
        //                } catch (SQLException e)
        //                {
        //                    e.printStackTrace();
        //                }
        //                增加一条记录
        //                String sql = "insert into information(姓名,性别,籍贯,出生年月) values(?,?,?,?)";
        //                List<Object> values = new ArrayList<>();
        //
        //                values.add("徐鼎");
        //                values.add("男");
        //                values.add("新疆维吾尔族自治区");
        //                values.add("1996-05-06");
        //
        //                try
        //                {
        //                    boolean flag = dbutil.updateByPrepareStatement(sql, values);
        //                    System.out.println(flag);
        //                } catch (SQLException e)
        //                {
        //                    e.printStackTrace();
        //                }
    }

    /**
     * @return a object of connection
     */
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
     * 通过反射机制访问数据库
     *
     * @param <T>
     * @param sql
     * @param value
     * @param cls
     * @return
     * @throws Exception
     */
    public <T> List<T> findMoreRefResult(String sql, List<Object> value, Class<T> cls) throws Exception
    {
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
                    System.out.println(e);
                }

            }
            list.add(resultObject);

        }
        return list;
    }

    public void closeConnection()
    {
        if (resultset != null)
        {
            try
            {
                resultset.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (prestmt != null)
        {
            try
            {
                prestmt.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        if (connection != null)
        {
            try
            {
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * add data to database
     *
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

    /**
     * to query one line data
     *
     * @param sql   the sql statement prepared to act
     * @param value the value prepared to change
     * @return one line data by map
     * @throws SQLException
     */
    public Map<String, Object> findSimpleResult(String sql, List<Object> value) throws SQLException
    {
        Map<String, Object> map = new HashMap<String, Object>();
        int index = 1;
        //get sql statement from input
        prestmt = connection.prepareStatement(sql);
        //set params of sql
        if (value != null && !value.isEmpty())
        {

            for (Object aValue : value)
            {
                prestmt.setObject(index++, aValue);
            }
        }
        //get the data of database
        resultset = prestmt.executeQuery();
        //get the column information
        ResultSetMetaData col_data = resultset.getMetaData();
        //get the column count
        int col_count = col_data.getColumnCount();
        //get the column and column's value and then put into HashMap
        while (resultset.next())
        {
            for (int i = 0; i < col_count; i++)
            {
                String cols_name = col_data.getColumnName(i + 1);
                Object cols_value = resultset.getObject(cols_name);
                if (cols_value == null)
                {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
        }
        return map;
    }

    /**
     * to query more line data
     *
     * @param sql   the sql statement prepared to act
     * @param value the value prepared to change
     * @return more line data by list
     * @throws SQLException
     */
    public List<HashMap<String, Object>> findMoreResult(String sql, List<Object> value) throws SQLException
    {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        int index = 1;
        prestmt = connection.prepareStatement(sql);
        if (value != null && !value.isEmpty())
        {

            for (Object aValue : value)
            {
                prestmt.setObject(index++, aValue);
            }
        }
        prestmt.executeQuery();
        resultset = prestmt.getResultSet();
        ResultSetMetaData col_data = resultset.getMetaData();
        int col_count = col_data.getColumnCount();
        while (resultset.next())
        {
            HashMap<String, Object> map = new HashMap<>();
            for (int i = 0; i < col_count; i++)
            {
                String cols_name = col_data.getColumnName(i + 1);
                Object cols_value = resultset.getObject(cols_name);
                if (cols_value == null)
                {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);

        }
        return list;
    }

    // jdbc的封装可以用反射机制来封装：
    public <T> T findSimpleRefResult(String sql, List<Object> value, Class<T> cls) throws Exception
    {
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
