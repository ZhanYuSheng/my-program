package com.zys.reflection;

import com.zys.bean.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 使用反射机制调用方法效率测试
 *
 * 使用反射调用方法比传统new对象方式调用方法效率要慢许多
 * 使用setAccessible(false)可以将反射执行方法的效率略微优化(感觉不明显)
 */
public class ReflectionEfficiency {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        traditionally();
        reflection();
        reflectionAccessibleFalse();
    }

    /**
     * 传统new对象方式调用方法
     */
    public static void traditionally(){
        Cat cat = new Cat();
        long startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++){
            cat.play();
        }
        System.out.println("new Cat()方式执行时间: " + (System.currentTimeMillis() - startTimeMillis));
    }

    /**
     * 通过反射方式调用方法
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
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

    /**
     * 通过反射调用方法，并将setAccessible设置为false
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void reflectionAccessibleFalse() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
        Class<?> aClass = Class.forName("com.zys.bean.Cat");
        Object o = aClass.newInstance();
        Method play = aClass.getMethod("play");
        play.setAccessible(false);
        long startTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++){
            play.invoke(o);
        }
        System.out.println("反射方式执行时间: " + (System.currentTimeMillis() - startTimeMillis));
    }
}
