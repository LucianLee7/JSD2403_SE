package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * JDK8之后,集合提供了"流"式API
 * 类似JAVA IO 流链接的思想,对集合元素进行流水线式的处理
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        //创建一个集合,存放10个0-100之间的随机数
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(10));
        }
        System.out.println(list);
        /*
            集合提供了方法:stream()
            该方法可以将一个集合转换为一个"流":Stream
            该流中"流动"的是集合元素
            可以在流上添加中间环节(相当于JAVA IO中的高级流)可以为流动过来的每个元素
            进行相关处理
            最后在终端环节收集最终处理完的元素

            Stream提供的中间环节:
            map:将流中经过的每个元素进行处理,改变为处理后的效果.
                要求处理时使用lambda表达式进行,返回值就是处理后的元素.
            filter:在流上添加一个过滤器，将满足过滤器要求的元素获取到
                   仅保留满足lambda表达式返回true的元素
            distinct:对经过的元素去重
            sorted:对集合元素排序

            Stream提供的终端环节:
            collect:收集流式操作完毕后的每一个元素
            终端环节是Stream的最终环节.

         */
        //将集合每个元素扩大3倍
        List<Integer >list2 = list.stream() //将集合变成一个Stream,流式处理集合元素
                              .map((e)->e*3)//中间环节,将元素扩大3倍
                              .collect(Collectors.toList());//终端环节,收集处理后的元素
        System.out.println(list2);

        //获取list集合中所有偶数
        List<Integer >list3 = list.stream()
                               //中间环节,过滤器,仅保留满足lambda表达式返回true的元素
                              .filter(e->e%2==0)
                              .collect(Collectors.toList());
        System.out.println(list3);

        //去掉list集合中的重复元素
        List<Integer> list4 = list.stream()
                                .distinct()//中间环节,去除重复元素
                                .collect(Collectors.toList());
        System.out.println(list4);

        //对list集合元素排序(流式操作后排序完的元素会被收集到另一个集合中,不改变list集合本身)
        List<Integer> list5 = list.stream()
                              //中间环节,sorted用于对集合元素进行排序
//                              .sorted()//默认升序,前提是元素可比较
                              .sorted((o1,o2)->o2-o1)//可自定义比较规则用于排序
                              .collect(Collectors.toList());
        System.out.println(list5);


        //对list集合元素扩大3倍,然后保留所有偶数,并去除重复值,然后从大到小排序
        List<Integer> list6 = list.stream()
                                  .map(e->e*3)
                                  .filter(e->e%2==0)
                                  .distinct()
                                  .sorted((o1,o2)->o2-o1)
                                  .collect(Collectors.toList());
        System.out.println(list6);

    }
}
