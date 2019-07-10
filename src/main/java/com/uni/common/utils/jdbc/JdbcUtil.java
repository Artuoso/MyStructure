package com.uni.common.utils.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
* @Description JDBC工具类
*
* @author Created by zc on 2019/7/10
*/
public class JdbcUtil {

    private static Connection connection = null;

    /**
     * 执行一条静态sql
     *
     * @author Created by zc on 2019/7/10
     */
    public static void executeSql(String sqlStr) {
        if (connection == null) {
            connection = JdbcConnection.getConnection();
        }

        try {
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement(sqlStr);
            ps.executeUpdate();
            connection.commit();
            // 关闭资源
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("执行sql异常。异常信息：" + e.getMessage());
            e.printStackTrace();
            try {
                connection.rollback();
                System.out.println("执行SQL异常，事务已回滚");
            } catch (SQLException e1) {
                System.out.println("事务回滚异常。异常信息：" + e1.getMessage());
                e1.printStackTrace();
            }

        }
    }

}
