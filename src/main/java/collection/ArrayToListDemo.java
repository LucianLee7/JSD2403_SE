package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转换为List集合
 * 数组的工具类:java.util.Arrays提供了一个静态方法:asList,可以将一个数组转换为List集合
 */
public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] array = {"one","two","three","four","five"};
        System.out.println(Arrays.toString(array));

        List<String> list = Arrays.asList(array);
        System.out.println(list);
        /*
            特点:对该集合或数组操作,他们都可以看到改后的效果.
         */
        list.set(0,"six");//修改集合第一个元素相当于修改数组第一个元素
        System.out.println(list);
        System.out.println(Arrays.toString(array));

        array[0] = "seven";//反之也是如此
        System.out.println(list);
        System.out.println(Arrays.toString(array));
        /*
            UnsupportedOperationException
            不支持      操作      异常
         */
//        list.add("eight");//原因:数组定长.因此会影响数组长度的操作都是不支持的,remove也不行

        //如果希望对集合增删元素,需要再创建一个集合并包含该集合所有元素即可
//        List<String> list2 = new ArrayList<>();
//        list2.addAll(list);
        /*
            所有集合都支持一个参数为Collection的构造器,作用是创建该集合的同时
            包含给定集合中的所有元素
         */
        List<String> list2 = new ArrayList<>(list);
        System.out.println("list2:"+list2);
        list2.add("eight");
        System.out.println("list2:"+list2);
    }
}

