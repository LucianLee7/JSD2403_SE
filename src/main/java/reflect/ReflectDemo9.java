package reflect;

import reflect.annotations.AutoRunClass;

/**
 * 反射机制访问类上的注解
 */
public class ReflectDemo9 {
    public static void main(String[] args) throws Exception {
        //查看Person类上是否被注解@AutoRunClass标注了
        Class cls = Class.forName("reflect.Person");
        /*
            所有反射对象都有一个方法:
            boolean isAnnotationPresent(Class cls)
            该方法的作用是判断当前反射对象表示的内容上是否被特定(参数表示的注解)注解标注了

            下面的代码使用类对象的该方法意思是判断类对象表示的类上是否被指定注解标注了
         */
        boolean mark = cls.isAnnotationPresent(AutoRunClass.class);
        if(mark){
            System.out.println("被标注了");
        }else{
            System.out.println("没有被标注");
        }
    }
}
