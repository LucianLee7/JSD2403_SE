package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用有参构造器实例化对象
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //Person(String,int)
        Person p = new Person("李四",15);
        System.out.println(p);

        Class cls = Class.forName("reflect.Person");
//        cls.getConstructor();//Person()  无参构造器
        /*
            反射对象之一
            java.lang.reflect.Constructor   构造器对象
            它的每一个实例用于表示一个特定的构造器

            目前位置见过的反射对象
            Class   类对象     每一个实例用于表示一个类
            Package 包对象     每一个实例用于表示一个包
            Method  方法对象    每一个实例用于表示一个方法
         */
        Constructor c = cls.getConstructor(String.class, int.class);
        Object obj = c.newInstance("王五",22);//new Person("王五",22)
        System.out.println(obj);
    }
}
