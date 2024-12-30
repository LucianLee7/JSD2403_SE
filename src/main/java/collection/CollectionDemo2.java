package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 元素equals与toString方法对集合的影响
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
//        Collection c = new ArrayList();
        Collection c = new HashSet();//不可重复集合
        c.add(new Point(1,2));
        c.add(new Point(3, 4));
        c.add(new Point(5, 6));
        c.add(new Point(7, 8));
        /*
            集合重写了toString格式:
            [元素1.toString(), 元素2.toString(), ...]
         */
        System.out.println(c);

        Point p = new Point(1,2);
        /*
            如果Point没有重写equals方法,那么默认的equals方法是比较地址,因此该元素
            与集合里的(1,2)元素不是同一个对象,所以对于Set集合而言也能存放进去
            为了解决该问题,元素应当妥善的重写equals方法.
         */
        c.add(p);//如果重写了equals方法,该元素无法添加到set集合中
        System.out.println(c);


        Point p2 = new Point(3,4);
        /*
            contains:包含

            boolean contains(Object o)
            判断当前集合是否包含参数给定的元素,若包含则返回true
         */
        //虽然p2不在集合中,但与集合现存元素存在equals比较为true的情况,所以集合认为包含该元素
        boolean contains = c.contains(p2);
        System.out.println("集合是否包含p2:"+contains);

    }
}






