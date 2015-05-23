package com.java.utils;

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

    public JDBCutils()
    {
        //TODO
    }
}
