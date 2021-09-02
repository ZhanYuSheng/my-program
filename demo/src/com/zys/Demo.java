package com.zys;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

public class Demo {

    public static void main(String[] args) {

        ProvinceEnum provinceEnum = ProvinceEnum.fromValue("731");

        System.out.println(provinceEnum);

        A a = new A();
        setA(a);
        System.out.println(a);

        String str = "456";
        changeStr(str);
        System.out.println(str);
    }

    private static void changeStr(String str){
        str = "123";
    }

    private static void setA(A a){
        a.setName("张三");
        a.setAge("1111");
        changeA(a);
    }

    private static void changeA(A a){
        a.setName("李四");
        a.setAge("2222");
    }

    static class A {
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }

}
