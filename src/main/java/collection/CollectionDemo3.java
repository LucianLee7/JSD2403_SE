package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 集合操作
 * 并集,交集,差集,包含
 */
public class CollectionDemo3 {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("java");
        c1.add("c++");
        c1.add(".net");
        System.out.println("c1:"+c1);

//        Collection c2 = new ArrayList();
        Collection c2 = new HashSet();
        c2.add("android");
        c2.add("ios");
        c2.add("java");//c1中存在的元素
        System.out.println("c2:"+c2);

        /*
            boolean addAll(Collection c)
            将给定集合中的所有元素添加到当前集合中
            取并集
         */
//        c1.addAll(c2);
        c2.addAll(c1);//由于c2是Set集,因此c1与c2的重复元素无法再次放入c2中
        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);

        Collection c3 = new ArrayList();
        c3.add("java");
        c3.add("php");
        c3.add("c++");
        System.out.println("c3:"+c3);
        /*
            boolean retainAll(Collection c)
            仅保留当前集合中与给定集合的共有元素(取交集)
            但是参数集合元素不受影响
         */
        c1.retainAll(c3);//仅保留c1中与c3的共有元素,c3集合元素不受任何影响
        System.out.println("c1:"+c1);
        System.out.println("c3:"+c3);
        /*
            boolean removeAll(Collection c)
            删除当前集合中与给定集合的共有元素(差集操作)
            参数集合不受影响
         */
//        c2.removeAll(c3);//将c2集合中与c3的共有元素删除,c3集合元素不受影响
        c2.removeAll(c3);//将c2集合中与c3的共有元素删除,c3集合元素不受影响
        System.out.println("c2:"+c2);
        System.out.println("c3:"+c3);
        //remove方法可以删除指定元素
        c2.remove("android");
        System.out.println("c2:"+c2);

        Collection c4 = new ArrayList();
        c4.add("ios");
        c4.add(".net");
        System.out.println("c4:"+c4);
        /**
         * boolean containsAll(Collection c)
         * 判断当前集合是否包含给定集合中的所有元素
         */
        boolean containsAll = c2.containsAll(c4);
        System.out.println("完全包含:"+containsAll);

    }
}


