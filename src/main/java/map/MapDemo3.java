package map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * JDK8之后,随着lambda表达式的出现,java为集合和Map提供了基于lambda表达式遍历的
 * 方式:forEach
 */
public class MapDemo3 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("语文",99);
        map.put("数学",98);
        map.put("英语",97);
        map.put("物理",96);
        map.put("化学",99);
        System.out.println(map);

//        map.forEach(
//                new BiConsumer<String, Integer>() {
//                    @Override
//                    public void accept(String k, Integer v) {
//                        System.out.println(k+"="+v);
//                    }
//                }
//        );

        map.forEach(
            (k,v)->System.out.println(k+"="+v)
        );




        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        //集合也有forEach方法
//        c.forEach(
//             (s)->System.out.println(s)
//        );
        /*
            lambda表达式的另一种简写:方法引用
            当lambda表达式的参数列表与其调用的方法参数列表一致时可以使用
            (s)->System.out.println(s)
             ^ --------一致----------^
            可以简写为:对象::方法名
             System.out::println
         */
        c.forEach(
                System.out::println
        );

    }
}
