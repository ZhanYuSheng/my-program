package com.zys;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableTest {

    /**
     * JDK 中自带的不可变集合: Collections.unmodifiableList() 存在一定的问题。
     * 当 unmodifiableList 发生修改，会产生 java.lang.UnsupportedOperationException。
     * 但 list 改变后，unmodifiableList 的值也跟着改变，所以不能算是真正的不可变集合。
     *
     * 要实现真正的不可变集合，推荐使用 guava 提供的 immutable 实现。
     */
    @Test
    public void jdkImmutableTest(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> unmodifiableList = Collections.unmodifiableList(list);
        System.out.println(unmodifiableList);

        list.add("4");
        System.out.println("向list中添加元素后的list: " + list);
        System.out.println("向list中添加元素后的unmodifiableList: " + unmodifiableList);
    }


}
