package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * lambda表达式 JDK8之后推出的一个新特性
 * 可以用更简洁的语法创建匿名内部类,旨在忽略累赘的匿名内部类语法,突出实现的逻辑
 * 语法:
 * (参数列表)->{
 *     方法体
 * }
 * 注意:lambda表达式可以实现的接口只能有一个抽象方法!
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        //为String创建一个比较器,比较规则:字多的大
        //匿名内部类写法:
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();//比较器的核心逻辑
            }
        };

        //lambda表达式写法:
        Comparator<String> c1 = (String o1, String o2)->{
            return o1.length()-o2.length();//比较器的核心逻辑
        };
        //方法的参数列表中参数类型可以不写
        Comparator<String> c2 = (o1, o2)->{
            return o1.length()-o2.length();//比较器的核心逻辑
        };
        //如果方法只有一句代码,方法的"{}"可以忽略不写,如果这句代码含有return,return要一同忽略
        Comparator<String> c3 = (o1, o2)->o1.length()-o2.length();//比较器的核心逻辑


        List<String> list = new ArrayList<>();
        list.add("克晶老师");
        list.add("传奇");
        list.add("王伟超");
        Collections.sort(list,(o1,o2)->o1.length()-o2.length());
    }
}
