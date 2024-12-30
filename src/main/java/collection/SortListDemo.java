package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 集合的排序
 * 集合的工具类:java.util.Collections提供了一个静态方法sort可以对List集合进行
 * 自然排序(从小到大)
 */
public class SortListDemo {
    public static void main(String[] args) {
        //创建一个List集合,存入10个随机整数,范围0-100之间
        List<Integer> list = new ArrayList<>();
        Random  r = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(100));
        }
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}






