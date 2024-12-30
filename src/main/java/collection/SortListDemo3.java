package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 排序字符串
 */
public class SortListDemo3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        /*
            String实现了Comparable接口,比较规则是按照字符的unicode编码对应的
            整数从小到大
         */
//        list.add("tom");
//        list.add("jerry");
//        list.add("mary");
//        list.add("john");
//        list.add("jack");
//        list.add("rose");
//        list.add("lily");
//        list.add("lilei");
//        list.add("hanmeimei");
//        list.add("Lucy");
//        list.add("Mike");
//        list.add("James");

        //默认的比较大小的规则对于排序中文没有什么意义
        list.add("克晶老师");
        list.add("传奇");
        list.add("王伟超");

        System.out.println(list);
//        Collections.sort(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
                //反过来减就是降序
                return o2.length()-o1.length();
            }
        });
        System.out.println(list);
    }
}



