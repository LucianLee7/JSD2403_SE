package reflect;

import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;

/**
 * 访问注解参数
 */
public class ReflectDemo11 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //获取Person类上sleep上的注解@AutoRunMethod中的参数值
        Class cls = Class.forName("reflect.Person");
        Method method = cls.getDeclaredMethod("sleep");
        //确保该方法有@AutoRunMethod注解
        if(method.isAnnotationPresent(AutoRunMethod.class)){
            /*
                所有反射对象都提供了方法:getAnnotation(Class<T> annotationClass)
                用来获取对应的注解
             */
            AutoRunMethod arm = method.getAnnotation(AutoRunMethod.class);
            int value = arm.value();//获取value参数的值
            System.out.println("注解参数值为:"+value);
        }
    }
}







