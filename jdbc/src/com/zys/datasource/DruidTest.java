package com.zys.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidTest {


    public static void main(String[] args) {
        try {
            druidTest();
         } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void druidTest() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("jdbc\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        Connection connection = dataSource.getConnection();
        System.out.println("druid获取链接成功");
        connection.close();
    }

}
