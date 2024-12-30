package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合只能保存引用类型元素,并且存放的也是元素的地址
 */
public class CollectionDemo4 {
    public static void main(String[] args) {
        Collection<Point> c = new ArrayList<>();
        Point p = new Point(1,2);
        c.add(p);
        System.out.println("p:"+p);//(1,2)
        System.out.println("c:"+c);//[(1,2)]
        p.setX(2);//通过p将Point对象的x更改
        System.out.println("p:"+p);//(2,2)
        //虽然程序没有显示的修改过集合,但是集合元素内容也改变了
        System.out.println("c:"+c);//[(2, 2)]
    }
}




