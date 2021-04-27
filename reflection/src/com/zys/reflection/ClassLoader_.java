package com.zys.reflection;

import java.util.*;
import java.lang.reflect.*;

/**
 * 该类用来演示类的静态加载与动态加载
 * 当未编写Dog类时，使用javac 命令编译该文件时会报错。
 *  ClassLoader_.java:11: 错误: 找不到符号
 *                 Dog dog = new Dog();
 * 编写Dog类后，未编写Person类。使用javac可以正常编译文件。但scanner输入2时，会抛出ClassNotFoundException: Person异常。
 *
 */
public class ClassLoader_{

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Integer key = scan.nextInt();
        switch(key){
            case 1 : 
                Dog dog = new Dog();
                dog.eat();
                break;
            case 2 :
                Class cls = Class.forName("Person");
                Object o = cls.newInstance();                
                Method method = cls.getMethod("eat");
                method.invoke(o);
            case 3 : 
                System.out.println("无事发生:)");
        }
    }

}

class Dog {

    public void eat(){
        System.out.println("吃着呢:)");
    }

}

class Person{
    
    public void eat(){
        System.out.println("吃着呢:)");
    }
}