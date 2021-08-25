package com.zys;

import org.junit.Test;

import java.util.function.Supplier;

/**
 * Supplier 类的演示和理解
 * todo 目前还只有演示，本人还不理解，有空阅读下参考文章(2)作者的其他文章。
 *
 * 参考文章:
 *  (1) https://www.cnblogs.com/liyihua/p/12286073.html
 *  (2) https://blog.csdn.net/qq_28410283/article/details/80625482
 */
public class SupplierTest {

    /**
     * 演示 Supplier 的简单使用
     */
    @Test
    public void supplierTest01(){
        String str1 = "Hello";
        String str2 = "World";
        System.out.println(getString(() -> str1 + str2));// HelloWorld
    }

    /**
     * 演示 Supplier 的简单使用
     */
    @Test
    public void supplierTest02(){
        //求最大值
        int[] numbers = {100, 200, 300, 400, 500, -600, -700, -800, -900, -1000};
        int maxNumber = getArrayMax(
                () -> {
                    int max = numbers[0];
                    for (int number : numbers){
                        if (max < number){
                            max = number;
                        }
                    }
                    return max;
                }
        );
        System.out.println("maxNumber = " + maxNumber);// 500
    }

    @Test
    public void supplierTest03(){
        Supplier<String> stringSupplier = String::new;
        System.out.println(stringSupplier.get());// ""

    }

    public String getString(Supplier<String> stringSupplier){
        return stringSupplier.get();
    }

    /**
     * 获取一个泛型参数指定类型的对象数据
     * @param integerSupplier 方法的参数为Supplier，泛型使用Integer
     * @return 指定类型的对象数据
     */
    public int getArrayMax(Supplier<Integer> integerSupplier){
        return integerSupplier.get();
    }

}
