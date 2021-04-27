package com.zys.reflection;

import com.zys.bean.Cat;

/**
 *
 * 内容来自B站视频“【韩顺平将Java】Java反射专题-反射 反射机制 类加载 reflection Class 类结构 等”; BV = "BV1g84y1F7df" P6
 * 1.Class也是普通类，因此也继承Object类【类图】
 * 2.Class类对象不是new出来的，而是系统创建的
 * 3.对于某个类的Class类对象，在内存中只有一份，因为类只加载一次
 * 4.每个类的实例都会记得自己是由哪个Class实例所生成
 * 5.通过Class可以完整的得到一个类的完整结构，通过一系列API
 * 6.Class对象是存放在堆的
 * 7.类的字节码二进制数据，是放在方法区的，有的地方称为类的元数据(包括方法代码，变量名，方法名，访问权限等等) https://www.zhihu.com/question/38496907
 */
public class Class_ {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        /*
         通过debug模式发现，new Cat();首先会调用 ClassLoader类的loadClass(String name)
         public Class<?> loadClass(String name) throws ClassNotFoundException {
            return loadClass(name, false);
         }
        */
        Cat cat = new Cat();

        /*
            仍然是调用ClassLoader类的loadClass(String name)，
            一个Class只能被加载一次，如果先执行了上面的new Cat();则Class.forName()时不会调用loadClass方法
        */
        Class cls1 = Class.forName("com.zys.bean.Cat");
        Class cls2 = Class.forName("com.zys.bean.Cat");

        System.out.println("cls1.hashCode = " + cls1.hashCode() + "| cls2.hashCode = " + cls2.hashCode());
    }

}
