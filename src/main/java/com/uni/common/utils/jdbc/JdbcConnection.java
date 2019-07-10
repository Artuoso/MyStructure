package com.uni.common.utils.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* @Description Jdbc配置和连接
*
* @author Created by zc on 2019/7/10
*/
public class JdbcConnection {

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/uniapi_dev?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    /**
     * 加载驱动并获取数据库连接
     *
     * @author Created by zc on 2019/7/10
     */
    private static void load() {
        try {
            // 加载驱动程序
            Class.forName(DRIVER_NAME);
            // 获取数据库连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动异常");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("获取数据库连接异常");
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection
     *
     * @author Created by zc on 2019/7/10
     */
    public static synchronized Connection getConnection() {
        if(connection == null) {
            load();
        }
        return connection;
    }
}
