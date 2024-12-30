package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 利用反射机制调用Person类中本类自己定义的所有无参且公开的方法
 */
public class Test2 {
    public static void main(String[] args) throws Exception {
        /*
            根据Person的类对象获取其本类自己定义的所有方法
            遍历这些方法，并逐一判断是否是public方法且没有参数
            如果满足上述要求就invoke执行该方法
         */
        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();//实例化一个Person
        //通过类对象获取Person中本类自己定义的所有方法
        Method[] methods = cls.getDeclaredMethods();
        for(Method method : methods){
            if(method.getModifiers()== Modifier.PUBLIC
                            &&
               method.getParameterCount()==0
            ){
                System.out.println("调用方法:"+method.getName()+"()");
                method.invoke(obj);
            }
        }
    }
}
