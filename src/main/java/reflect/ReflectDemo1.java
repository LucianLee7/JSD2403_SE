package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * reflect:反射,反映
 *
 * 反射是java的动态机制,允许程序在[运行期间]再确定对象的实例化,方法的调用,属性的操作等
 */
public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
            反射的第一步是获取要操作的类的类对象
            而获取一个类的类对象方式:
            1:类名.class
            Class cls = String.class;//获取String的类对象
            Class cls = int.class;//获取int的类对象  注意:基本类型获取类对象只能使用该方式

            2:Class.forName(String className)
            根据给定的类的完全限定名获取该类的类对象
            类的完全限定名:包名.类名
            Class cls = Class.forName("java.lang.String");

            3:同类加载器：ClassLoader进行

            类对象:Class的实例
            JVM加载一个类的字节码文件后，就会实例化一个Class实例与之绑定，通过这个类对象
            可以反映出其表示的类的一切信息(类名，包信息，有哪些方法，属性，构造器等等)
         */
        //获取String的类对象
//        Class cls = String.class;
//        Class cls = ArrayList.class;

        //获取String的类对象
//        Class cls = Class.forName("java.lang.String");
        /*
            java.lang.String
            java.util.ArrayList
            java.util.HashMap
            java.io.FileOutputStream
            reflect.Person
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个类名:");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);


        //获取类对象所表示的类的完全限定名
        String name = cls.getName();
        System.out.println(name);
        //仅获取类名
        name = cls.getSimpleName();
        System.out.println(name);

        //获取包信息
        /*
            Package 包对象
            与Class类相似，它的每一个实例仅表示一个包的信息
         */
        Package p = cls.getPackage();//获取String的包信息
        System.out.println(p.getName());//获取包名
        /*
            通过类对象获取其表示的类的所有公开方法
            Method类 方法对象
            该类的每一个实例用于表示某个类中的某个方法
         */
        Method[] methods = cls.getMethods();
        System.out.println(name+"类共有"+methods.length+"个公开方法");
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }
}






