package reflect;

import reflect.annotations.AutoRunMethod;

import java.lang.reflect.Method;

/**
 * 访问方法上是否被特定注解标注
 */
public class ReflectDemo10 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //查看Person类上的study方法是否被注解@AutoRunMethod标注
        Class cls = Class.forName("reflect.Person");
//        Method method = cls.getDeclaredMethod("study");
        Method method = cls.getDeclaredMethod("playGame");
        if(method.isAnnotationPresent(AutoRunMethod.class)){
            System.out.println("方法被标注了");
        }else{
            System.out.println("没有被标注");
        }
    }
}







