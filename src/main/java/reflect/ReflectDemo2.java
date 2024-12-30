package reflect;

import java.util.Scanner;

/**
 * 使用反射机制实例化对象
 * Class提供了一个方法:
 * Object newInstance()
 * 可以调用其表示的类的【默认构造器,即：无参构造器】实例化对象
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Person p = new Person();
        System.out.println(p);

//        Class cls = Class.forName("reflect.Person");
        /*
            reflect.Person
            java.util.ArrayList
            java.util.HashMap
            java.util.Date   日期类，实例化后默认表示当前系统时间
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个类名");
        String name = scanner.nextLine();
        Class cls = Class.forName(name);
        Object obj = cls.newInstance();
        System.out.println(obj);
    }
}
