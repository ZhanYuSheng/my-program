package com.zys;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class SqlInjection {


    public static void main(String[] args) {
        try {
//            selectAdminByStatement("1' OR '1' = '1", "1' OR '1' = '1");
            selectAdminByPrepareStatement("admin", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectAdminByStatement(String userName, String pwd) throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM admin WHERE username = '").append(userName).append("' AND password = '").append(pwd).append("';");

        System.out.println("SQL: " + sql);

        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql.toString());

            while (resultSet.next()){
                String name = resultSet.getString(1);
                String passWord = resultSet.getString(2);
                System.out.println("用户名: " + name + ", 密码: " + passWord);
            }
        } finally {
            close(connection, statement, resultSet, null);
        }
    }

    public static void selectAdminByPrepareStatement(String userName, String passWord) throws Exception {
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        System.out.println("预编译前SQL: " + sql);

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, passWord);

            System.out.println("预编译后SQL: " + preparedStatement);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("用户名: " + resultSet.getString(1) + ", 密码: " + resultSet.getString(2));
            }
        } finally {
            close(connection, null, resultSet, preparedStatement);
        }
    }

    private static Connection getConnection() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc\\src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");

        return DriverManager.getConnection(url, user, password);
    }

    private static void close(Connection connection, Statement statement, ResultSet resultSet, PreparedStatement preparedStatement) throws Exception {
        if (connection != null){
            connection.close();
        }
        if (statement != null){
            statement.close();
        }
        if (resultSet != null){
            resultSet.close();
        }
        if (preparedStatement != null){
            preparedStatement.close();
        }
    }
}
