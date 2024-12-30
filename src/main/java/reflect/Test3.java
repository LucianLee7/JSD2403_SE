package reflect;

import reflect.annotations.AutoRunClass;

import java.util.Scanner;

/**
 * 要求:程序启动后，在控制台上任意输入一个类的完全限定名
 * 如果该类被注解@AutoRunClass标注，则进行实例化，否则仅通知该类没有被此注解标注
 *
 * reflect.Person
 * 输出Person的toString..
 *
 * reflect.Student
 * Student类没有被注解标注!
 */
public class Test3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名:");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);

        if(cls.isAnnotationPresent(AutoRunClass.class)){
            System.out.println("开始实例化对象:"+cls.getSimpleName());
            Object obj = cls.newInstance();
            System.out.println(obj);
        }else{
            System.out.println(cls.getSimpleName()+"类没有被注解标注!");
        }

    }
}
