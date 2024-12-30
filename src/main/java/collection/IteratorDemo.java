package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 遍历集合元素
 *                         die
 * 集合提供了统一的遍历元素方式:迭代器模式
 * 集合提供的方法:
 * Iterator iterator()
 * 该方法会返回一个用于遍历当前集合的迭代器
 *
 * java.util.Iterator接口
 * 迭代器接口规定了几个方法,用于遍历集合元素.不同的集合都实现了一个迭代器用于遍历自身元素
 * 我们不需要记住那些实现类的名字.
 * 迭代器遍历集合的遵循的步骤:问->取->删   删除不是必须操作
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        //通过集合获取遍历它元素的迭代器
        Iterator<String> it = c.iterator();//迭代器泛型应当与集合指定的泛型一致
        /*
            迭代器的相关方法:
            boolean hasNext()
            通过迭代器判断集合是否还有下一个元素可供遍历
            E next()
            迭代器移动到集合下一个元素的位置并获取该元素
            返回值的类型是迭代器指定的类型,应当与集合指定的一致
         */
        while(it.hasNext()){
            String e = it.next();
            //遍历过程中删除所有"#"
            if("#".equals(e)){
                //迭代器要求遍历的过程中不可以通过集合的方法增删元素,否则会抛出异常
//                c.remove(e);
                //迭代器的remove方法删除本次通过next方法获取的元素
                it.remove();
            }
            System.out.println(e);
        }

        System.out.println(c);

    }
}
