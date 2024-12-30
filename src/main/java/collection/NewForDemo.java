package collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK5之后推出的另一个新特性:增强型for循环
 * 也称为新循环,它不取代传统for循环的工作,只是用来使用相同的语法遍历集合或数组.
 *
 * 语法:
 * for(元素类型 变量名 : 集合或数组){
 *     ...
 * }
 */
public class NewForDemo {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);
        //新循环会依次将每个元素赋值给变量e然后进入循环体
        /*
            新循环不是新的语法,不是虚拟机认可的,是编译器认可的,编译器会将代码改为
            迭代器形式遍历,因此遍历过程中不能增删元素
         */
        for(String e : c){
            System.out.println(e);
        }

        String[] array = {"one","two","three","four","five"};
        for(int i=0;i< array.length;i++){
            String e = array[i];
            System.out.println(e);
        }
        //新循环遍历数组
        /*
            新循环遍历数组会被改为普通for循环遍历
         */
        for(String e :array){
            System.out.println(e);
        }
    }
}





