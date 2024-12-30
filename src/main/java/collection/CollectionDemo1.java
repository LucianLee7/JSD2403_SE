package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Collection集合
 *
 * java.util.Collection是所有集合的顶级接口,里面定义了所有集合都具有的功能
 * 集合与数组一样,用于保存一组数据结构,并且支持众多数据结构
 * 常见的子接口:
 * java.util.List:可重复且有序的集合
 * java.util.Set:不可重复的集合
 * 这里说的重复是指元素是否可以重复,重复的标准是元素的equals比较结果是否为true
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
//        Collection c = new HashSet();//不可重复
        /*
            boolean add(E e)
            将元素添加到集合中,如果元素成功添加到集合中则返回true
         */
        System.out.println(c.add("one"));
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c.add("one"));//Set集合不能存放重复元素,返回值false
        System.out.println(c);
        /*
            size:尺寸,大小

            int size()
            返回当前集合的元素个数
         */
        int size = c.size();
        System.out.println("size:"+size);
        /*
            empty:空的

            boolean isEmpty()
            判断当前集合是否为一个空集(不含有元素)
            当集合的size=0时,isEmpty返回true
         */
        boolean isEmpty = c.isEmpty();
        System.out.println("是否为空集:"+isEmpty);
        /*
            void clear()
            清空集合
         */
        c.clear();
        System.out.println(c);
        System.out.println("size:"+c.size());
        System.out.println("是否为空集:"+c.isEmpty());

    }
}





