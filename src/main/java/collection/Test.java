package collection;

import java.util.*;

/**
 * 创建一个存放整数类型的集合,里面保存10个0-100之间的随机数
 * 排序集合并输出,规则:从大到小
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(r.nextInt(100));
        }
        System.out.println(list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        System.out.println(list);
    }
}
