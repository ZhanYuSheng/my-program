package com.zys.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GuavaDemo {

    /**
     * guava 提供了对JDK标准集合类里的 immutable 版本的简单方法实现，以及 guava 自己的一些专门集合类的 immutable实现，
     * 当你不希望修改一个集合类，或者想做一个常量集合类时，使用 immutable 实现类就是一个最佳的编程实践。
     *
     * immutable 集合的创建方式:
     *  <1> ImmutableList.copyOf(list)
     *  <2> ImmutableList.of("tom", "jerry", "李狗蛋")
     *  <3> 使用 Builder 类
     */
    @Test
    public void immutableSetDemo(){

        // 该 list 集合用来演示，当 list 发生改变时，immutableList 的值是否会发生改变。
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        // immutable 集合创建方式<1>
        ImmutableList<String> immutableList = ImmutableList.copyOf(list);
        System.out.println("copyOf 方式创建: " + immutableList);
        list.add("4");
        System.out.println("修改 list 之后的 immutableList: " + immutableList);

        // immutable 集合创建方式<2>
        ImmutableList<String> of = ImmutableList.of("tom", "jerry", "李狗蛋");
        System.out.println("of 方式创建: " + of);

        // immutable 集合创建方式<3>
        ImmutableList<String> builder = ImmutableList.<String>builder().add("a").add("b").add("c").build();
        System.out.println("builder 方式创建: " + builder);
    }

}
