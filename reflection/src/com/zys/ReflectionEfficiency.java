package com.zys;

import com.zys.bean.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionEfficiency {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        traditionally();
        reflection();
    }

    public static void traditionally(){
        Cat cat = new Cat();
        long startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++){
            cat.play();
        }
        System.out.println("new Cat()方式执行时间: " + (System.currentTimeMillis() - startTimeMillis));
    }

    public static void reflection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.zys.bean.Cat");
        Object o = aClass.newInstance();
        Method play = aClass.getMethod("play");
        long startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++){
            play.invoke(o);
        }
        System.out.println("反射方式执行时间: " + (System.currentTimeMillis() - startTimeMillis));
    }

}
