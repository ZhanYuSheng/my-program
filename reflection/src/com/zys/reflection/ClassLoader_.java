package com.zys.reflection;

import java.util.*;
import java.lang.reflect.*;

/**
 * ����������ʾ��ľ�̬�����붯̬����
 * ��δ��дDog��ʱ��ʹ��javac ���������ļ�ʱ�ᱨ��
 *  ClassLoader_.java:11: ����: �Ҳ�������
 *                 Dog dog = new Dog();
 * ��дDog���δ��дPerson�ࡣʹ��javac�������������ļ�����scanner����2ʱ�����׳�ClassNotFoundException: Person�쳣��
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
                System.out.println("���·���:)");
        }
    }

}

class Dog {

    public void eat(){
        System.out.println("������:)");
    }

}

class Person{
    
    public void eat(){
        System.out.println("������:)");
    }
}