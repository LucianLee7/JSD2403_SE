package reflect;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 使用反射机制调用方法
 */
public class ReflectDemo4 {
    public static void main(String[] args)throws Exception  {
        Person p = new Person();
        p.sayHello();

//        Class cls = Class.forName("reflect.Person");
//        Object obj = cls.newInstance();//new Person();
//        /*
//            Method 方法对象
//            每一个实例用于表示类中的一个方法
//        */
//        Method method = cls.getMethod("sayHello");
//        //invoke用来执行Method对象表示的方法，需要传入该方法的所属对象
//        method.invoke(obj);//obj.sayHello();


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名:");
        String className = scanner.nextLine();
        System.out.println("请输入方法名:");
        String methodName = scanner.nextLine();

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }
}
