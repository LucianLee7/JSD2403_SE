package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  创建一个List集合,里面存放5个随机的整数,范围0-100(包含100)
 *  这5个数字相当于是一个同学5门成绩
 *
 *  判断该学生是否全部及格?
 *  获取5门成绩的总分?
 */
public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            list.add(r.nextInt(101));
        }
        System.out.println(list);

        System.out.println(list.stream().allMatch(i -> i >= 60));
        int sum = list.stream().reduce((e1,e2)->e1+e2).get();
        System.out.println("总分"+sum);
    }
}
