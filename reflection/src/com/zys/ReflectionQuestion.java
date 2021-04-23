package com.zys;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {

    //通过配置文件，使用反射机制生成对象并调用方法
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\config.properties"));

        String classPath = properties.getProperty("classPath");
        String methodName = properties.getProperty("methodName");
        System.out.println("从配置文件中读取classPath: " + classPath + "; methodName: " + methodName);

        Class<?> aClass = Class.forName(classPath);
        Object o = aClass.newInstance();
        System.out.println(o.getClass() + "类加载完成");
        Method method = aClass.getMethod(methodName);
        System.out.println(method.getName() + "方法加载完成");

        method.invoke(o);
    }

}
