package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * 常用的终端操作
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(r.nextInt(100));
        }
        System.out.println(list);

        /*
            min:最终获取集合中的最小值
            max:获取最大值
            anyMatch:判断当前集合是否有至少一项符合lambda条件要求则返回true
            allMatch:当集合所有元素全部匹配lambda表达式条件则返回true
            noneMath:当集合所有元素都不匹配lambda表达式条件则返回true
            reduce:积累操作,将流中积累操作后,将最终结果返回

            Optional有点类似于包装类,每个示例内部保存一个java中的对象
         */
//         Optional<Integer> o = list.stream().min((o1, o2) -> o1 - o2);
//         Integer min = o.get();

        int min = list.stream().min((o1, o2) -> o1 - o2).get();
        System.out.println(min);

        //获取集合中的最大值
        int max = list.stream().max((o1, o2) -> o1 - o2).get();
        System.out.println(max);


        //list集合中是否含有偶数?
        boolean anyMatch = list.stream().anyMatch(e->e%2==0);
        System.out.println(anyMatch?"有偶数":"没有偶数");

        //查看list集合是否所有元素都大于5
        boolean allMatch = list.stream().allMatch(e->e>5);
        System.out.println(allMatch?"都>5":"不都>5");

        //集合是否所有元素都是奇数
        boolean noneMatch = list.stream().noneMatch(e->e%2==0);
        System.out.println(noneMatch?"都是奇数":"都都是奇数");

        /*
            对集合元素求和
            [1,2,3,4,5,6,7,8,9]
            list.stream().reduce((e1,e2)->e1+e2)

            第一次:将集合前两个元素传入lambda,将结果作为第一个元素
            list.stream().reduce((e1,e2)->e1+e2)   e1+e2=3
                                   1  2

            第二次:将集合第三个元素与上一次lambda结果传入
            list.stream().reduce((e1,e2)->e1+e2)   e1+e2=6
                                   3  3
                                   ^  ^
                       上次reduce结果  第三个元素

            第三次:将集合第三个元素与上一次lambda结果传入
            list.stream().reduce((e1,e2)->e1+e2)
                                  6  4
         */
        int sum = list.stream().reduce((e1,e2)->e1+e2).get();
        System.out.println("求和:"+sum);
    }
}


