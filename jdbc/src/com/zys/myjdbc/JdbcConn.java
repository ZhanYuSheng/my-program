package com.zys.myjdbc;

import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JdbcConnect实例
 *
 */
public class JdbcConn {


    public static void main(String[] args) {
        conn05();
    }

    public static void conn01(){
        Connection connect = null;
        try {
            Driver driver = new Driver();

            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "123456");
            String url = "jdbc:mysql://localhost:3306/db1";

            connect = driver.connect(url, properties);
            System.out.println("方式01: " + connect);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            closeConnect(connect);
        }
    }

    public static void conn02(){
        Connection connect = null;
        try {
            Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver driver = (Driver)aClass.newInstance();

            Properties properties = new Properties();
            properties.setProperty("user", "root");
            properties.setProperty("password", "123456");
            String url = "jdbc:mysql://localhost:3306/db1";

            connect = driver.connect(url, properties);
            System.out.println("方式02: " + connect);

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnect(connect);
        }
    }

    public static void conn03(){
        Connection connect = null;
        try {
            Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
            Driver driver = (Driver)aClass.newInstance();
            String url = "jdbc:mysql://localhost:3306/db1";
            String user = "root";
            String password = "123456";
            DriverManager.registerDriver(driver);
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("方式03: " + connect);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnect(connect);
        }
    }

    public static void conn04(){
        Connection connect = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/db1";
            String user = "root";
            String password = "123456";
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("方式04: " + connect);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnect(connect);
        }
    }

    public static void conn05(){
        Connection connect = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Properties properties = new Properties();
            properties.load(new FileInputStream("jdbc/src/mysql.properties"));
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connect = DriverManager.getConnection(url, user, password);
            System.out.println("方式05: " + connect);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }finally {
            closeConnect(connect);
        }
    }

    private static void closeConnect(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
