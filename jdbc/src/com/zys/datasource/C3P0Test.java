package com.zys.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;

import java.sql.Connection;
import java.util.Properties;

public class C3P0Test {

    public static void main(String[] args) {
        try {
            c3p0Test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //c3p0会读取src下的c3p0-config.xml文件，可以直接注入属性，不需要set各种参数
    public static void c3p0Test() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc\\src\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        comboPooledDataSource.setInitialPoolSize(20);
        comboPooledDataSource.setMaxPoolSize(100);

        Connection connection = comboPooledDataSource.getConnection();
        System.out.println("获取链接成功");
    }

}
