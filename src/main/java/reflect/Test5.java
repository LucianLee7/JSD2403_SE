package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 程序启动后，要求输入一个类名
 * 如果这个类被注解@AutoRunClass标注了，那么进行实例化，并自动调用该类中所有
 * 被注解@AutoRunMethod标注的方法若干次，具体次数有该方法上@AutoRunMethod注解参数决定
 *
 * 否则输出该类没有被标注
 *
 * reflect.Person
 *
 */
public class Test5 {
    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名:");
        String className = scanner.nextLine();
        Class cls = Class.forName(className);
        if(cls.isAnnotationPresent(AutoRunClass.class)){
            System.out.println("开始实例化对象:"+cls.getSimpleName());
            Object obj = cls.newInstance();

            //获取该类所有定义的方法
            Method[] methods = cls.getDeclaredMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(AutoRunMethod.class)){
                    AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
                    int value = arm.value();
                    System.out.println("调用方法:"+method.getName()+"()"+value+"次:");
                    for(int i=0;i<value;i++) {
                        method.invoke(obj);
                    }
                }
            }


        }else{
            System.out.println(cls.getSimpleName()+"类没有被注解标注!");
        }
    }
}
