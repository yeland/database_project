package dao;

import java.sql.*;

public class Connect {
    private static final String URL = "jdbc:mysql://localhost:3306/student_examination_sys?useSSL=false";
    private static final String NAME = "root";
    private static final String PASSWORD = "123123";

    public static ResultSet operation(String sql) {
        Connect connect = new Connect();
        Connection connection = connect.getConnect();
        Statement statement = connect.getStatement(connection);
        ResultSet resultSet = connect.executeSQL(statement, sql);
        return  resultSet;
    }

    private Connection getConnect() {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动不存在！");
        }

        Connection conn = null;
        try {
            //创建连接
            conn = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
        }

        return conn;
    }

    private Statement getStatement(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("创建Statement失败！");
        }

        return statement;
    }

    private ResultSet executeSQL(Statement statement, String sql) {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("查询失败！");
        }

        return rs;
    }

    private static void closeConnect(ResultSet rs, Statement st, Connection conn) {
        if (rs != null) {   // 关闭记录集
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {   // 关闭声明
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {  // 关闭连接对象
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

