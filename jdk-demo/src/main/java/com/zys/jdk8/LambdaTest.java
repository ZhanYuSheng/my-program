package com.zys.jdk8;

import org.junit.Test;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

/**
 * Lambda 表达式简介
 *
 * Lambda 表达式可以理解为简洁地表示可传递的匿名函数的一种方式：它没有名称，但它有参数列表，函数主体，返回类型，可能还有一个可以抛出的异常列表。
 * Lambda 表达式的基本语法:
 *  java 中引入了一个新的操作符"->"，该操作符在很多资料中称为“箭头操作符”或者"lambda 操作符"。箭头操作符将 lambda 分为两个部分:
 *      (1) 左侧: lambda 表达式的参数列表
 *      (2) 右侧: lambda 表达式中所需要执行的功能，即 lambda 函数体
 * Lambda 表达式的语法格式:
 *  (1) 无参数无返回值的用法: () -> System.out.println("Hello Lambda");{@link #test1()}
 *  (2) 有一个参数，无返回值的用法: (x) -> System.out.println(x); 或者 x -> System.out.println(x); 一个参数，可以省略参数的小括号。{@link #test2()}
 *  (3) 有两个参数，有返回值的: (x, y) -> x + y;{@link #test3()}
 *  (4) 多行语句，分别在无返回值和有返回值的抽象类中的用法。{@link #test4()}
 *  (5) Lambda 的类型推断。{@link #test5()}
 * 可以看到，在 Lambda 中的参数列表，可以不用写参数的类型，跟 java7 中 new ArrayList<>();不需要指定泛型类型，这样的"<>"棱形操作符一样，根据上下文做类型的推断。
 * Lambda 表达式中，需要有函数式接口的支持
 *  函数式接口的定义: 只有一个抽象方法的接口称为函数式接口。
 *  可以适用 @FunctionalInterface 注解修饰，对该接口做检查。如果接口中有多个抽象方法，适用该注解时会有语法报错。
 *
 * ---------------------------------------------------------------------------------------------------------------------
 * Java8 Lambda 表达式，方法的引用以及构造器的引用
 *
 * 《Java8实战》中对"方法的引用"的介绍:
 *      方法的引用可以让你重复使用现有的方法定义，并像 Lambda 一样传递他们。
 *
 *
 * 参考文章:
 *  (1)《java8 Lambda表达式简介》https://blog.csdn.net/qq_28410283/article/details/80961022
 */
public class LambdaTest {

    /**
     * (1) 无参数无返回值的用法: () -> System.out.println("Hello Lambda");
     */
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Runnable");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("Hello Lambda");
        r2.run();
    }

    /**
     * (2) 有一个参数，无返回值的用法: (x) -> System.out.println(x);或者 x -> System.out.println(x);一个参数，可以省略参数的小括号。
     */
    @Test
    public void test2(){
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("有一个参数，无返回值的用法(Consumer函数式接口)");
    }

    /**
     * (3) 有两个参数，有返回值的: (x, y) -> x + y;
     */
    @Test
    public void test3(){
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println(binaryOperator.apply(1, 2));// 3
    }

    /**
     * (4) 多行语句，分别在无返回值和有返回值的抽象类中的用法
     */
    @Test
    public void test4(){
        // 无返回值 lambda 函数体中用法
        Runnable r1 = () -> {
            System.out.println("Hello Lambda");
            System.out.println("Hello Runnable");
        };
        r1.run();
        // 有返回值 lambda 函数体中用法
        BinaryOperator<Integer> binaryOperator = (x, y) -> {
            int a = x * 2;
            int b = y + 2;
            return a + b;
        };
        System.out.println(binaryOperator.apply(1, 2));// 6
    }

    /**
     * (5) Lambda 的类型推断。
     */
    @Test
    public void test5() {
        BinaryOperator<Integer> binary = (Integer x, Integer y) -> x + y;
        System.out.println(binary.apply(1, 2));// 3
    }

}
