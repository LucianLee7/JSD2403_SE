package collection;

import java.util.*;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(10,20));
        list.add(new Point(5, 30));
        list.add(new Point(20, 10));
        list.add(new Point(30, 5));
        list.add(new Point(15, 15));
        System.out.println(list);
        /*
            compare:比较

            Collections.sort(List list)
            该方法在排序集合时,要求集合元素必须实现一个接口:Comparable
            因为该接口中定义了一个用于比较两个对象之间大小关系的方法:compareTo()
            sort方法就是利用这个方法确定元素之间的大小关系从而进行排序的

            实际开发中对于我们子集定义的类作为集合元素时不建议做上述操作,因为这会导致
            程序出现了侵入性.
            侵入性:当我们调用某个API时,它要求我们为其修改其他额外地方的代码,这样的现象
            称为侵入性,它不利于程序的后期维护.
         */
//        Collections.sort(list);
//        MyComparator comparator = new MyComparator();
//        Collections.sort(list,comparator);

        Comparator<Point> comparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
                return len1-len2;
            }
        };
        Collections.sort(list,comparator);


        Collections.sort(list,new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
                int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
                return len1-len2;
            }
        });

        System.out.println(list);
    }
}

/*class MyComparator implements Comparator<Point>{
    *//**
     * 实现比较器接口就需要实现compare方法,该方法用于定义两个元素的比较大小规则
     * 当返回值>0时,表达o1>o2的
     * 当返回值<0时,表达o1<o2的
     * 当返回值=0时,表达o1=o2
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return
     *//*
    @Override
    public int compare(Point o1, Point o2) {
        int len1 = o1.getX()*o1.getX()+o1.getY()*o1.getY();
        int len2 = o2.getX()*o2.getX()+o2.getY()*o2.getY();
        return len1-len2;
    }
}*/
