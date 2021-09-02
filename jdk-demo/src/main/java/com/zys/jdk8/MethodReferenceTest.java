package com.zys.jdk8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法的引用以及构造器的引用
 *
 * 《Java8实战》中对"方法的引用"的介绍:
 *      方法的引用可以让你重复使用现有的方法定义，并像 Lambda 一样传递他们。在一些情况下，比起使用 Lambda表达式，他们似乎更易读，感觉也更自然。
 *
 * 方法引用的语法主要有三类:
 *  (1) 指向静态方法的方法引用，例如{@link Integer#parseInt(String)}可以写成 Integer::parseInt;
 *      "类::静态方法名"{@link #test1()}
 *  (2) 指向任意类型实例方法的方法引用，例如{@link String#length()}可以写成 String::length;
 *      “类::实例方法名”{@link #test2()}
 *  (3) 指向现有对象的实例方法的方法引用
 *      “对象::实例方法名”{@link #test3()}
 *
 *  构造器的引用
 *
 * 参考文章:
 *  (1)《java8 lambda表达式，方法的引用以及构造器的引用》https://blog.csdn.net/qq_28410283/article/details/80963351
 */
public class MethodReferenceTest {

    /**
     * 指向静态方法的方法引用，例如{@link Integer#parseInt(String)}可以写成 Integer::parseInt;
     */
    @Test
    public void test1(){
        // 类::静态方法名
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println("comparator1: " + comparator1.compare(3, 2));// comparator1: 1
        Comparator<Integer> comparator2 = (x, y) -> Integer.compare(x, y);
        System.out.println("comparator2: " + comparator2.compare(3, 2));// comparator2: 1

        Comparator<Integer> comparator3 = Integer::compareTo;
        System.out.println("comparator3: " + comparator3.compare(3, 2));// comparator3: 1
        Comparator<Integer> comparator4 = (x, y) -> x.compareTo(y);
        System.out.println("comparator4: " + comparator4.compare(3, 2));// comparator4: 1
    }

    /**
     * 指向任意类型实例方法的方法引用，例如{@link String#length()}可以写成 String::length;
     */
    @Test
    public void test2(){
        // 类::实例方法名
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("a", "b"));// false

        BiPredicate<String, String> biPredicate = String::equals;
        System.out.println(biPredicate.test("a", "b"));// false
    }

    /**
     * 指向现有对象的实例方法的方法引用
     */
    @Test
    public void test3(){
        // 对象::实例方法名
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("abc");// abc

        Consumer<String> stringConsumer = System.out::println;
        consumer.accept("abc");// abc

        Emp emp = new Emp("上海", "小明", 18);
        Supplier<String> supplier = () -> emp.getAddress();
        System.out.println(supplier.get());// 上海

        Supplier<String> supplier1 = emp::getAddress;
        System.out.println(supplier1.get());// 上海
    }

    static class Emp {
        private String address;

        private String name;

        private Integer age;

        public Emp() {

        }

        public Emp(String address) {
            this.address = address;
        }

        public Emp(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Emp(String address, String name, Integer age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Emp{" +
                    "address='" + address + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
