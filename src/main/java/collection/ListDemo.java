package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * java.util.List集合
 * List接口继承自Collection接口
 * 特点:有序且可以存放重复元素
 * 常用实现类:
 * java.util.ArrayList:内部使用数组实现,查询性能更好
 * java.util.LinkedList:内部使用链表实现,首尾增删元素性能更好
 *
 *
 * List提供了一套通过下标操作元素的方法
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);
        /*
            int get(int index)
            获取给定下标位置上对应的元素
         */
        String e = list.get(2);//array[2]
        System.out.println(e);
        //List集合可以通过遍历下标达到遍历集合元素的目的
        for(int i=0;i<list.size();i++){
            e = list.get(i);
            System.out.println(e);
        }

        /*
            E set(int index, E e)
            将给定元素设置到指定位置上,返回值为被替换的元素
         */
        String old = list.set(2,"six");
        System.out.println(list);
        System.out.println("被替换的元素:"+old);

        //将集合元素反转
//        for (int i=0;i<list.size()/2;i++){
////            //正数位置元素获取
////            String s = list.get(i);//s:one
////            //将正数元素设置到倒数位置上
////            s = list.set(list.size()-1-i,s);//s:five
////            //将原倒数位置的元素设置到正数位置上
////            list.set(i, s);
//
//            list.set(i, list.set(list.size()-1-i,list.get(i)));
//        }

//        for (int i=0;i<list.size()/2;list.set(i, list.set(list.size()-1-i,list.get(i++))));

        //Collections是集合的工具类,提供的静态方法reverse可以对List集合反转
        Collections.reverse(list);

        System.out.println(list);//[five,four,six,two,one]

    }
}







