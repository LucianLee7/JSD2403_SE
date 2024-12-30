package reflect;

import java.lang.reflect.Method;

/**
 *  访问私有成员，暴力反射
 *  反射机制访问类的私有方法
 */
public class ReflectDemo6 {
    public static void main(String[] args) throws Exception{
//        Person p = new Person();
//        p.hehe();//私有成员不可以在类的外部被调用

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();
        /*
            Class中获取方法:
                Method[] getMethods()
                Method getMethod(String name, Class... parameterTypes)
                上述两个方法只能获取到公开方法(包含从超类继承的)

                Method[] getDeclaredMethods()
                Method getDeclaredMethod(String name, Class... parameterTypes)
                上述两个方法可以获取到本类自己定义的方法，包含私有方法，不含有超类继承的
         */
//        Method[] methods = cls.getMethods();
//        Method[] methods = cls.getDeclaredMethods();
//        for (Method m : methods) {
//            System.out.println(m.getName());
//        }
        Method method = cls.getDeclaredMethod("hehe");
        method.setAccessible(true);//强行打开访问权限
        method.invoke(obj);//
        method.setAccessible(false);//好习惯，用完了关闭权限;
    }
}




