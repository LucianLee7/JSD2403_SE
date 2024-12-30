package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用反射机制，调用Student的无参构造器，和有参构造器分别实例化对象
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("reflect.Student");
        Object o1 = cls.newInstance();
        System.out.println(o1);

        //有参构造器
        Constructor c = cls.getConstructor(String.class,int.class,char.class);
        Object o2 = c.newInstance("李四",22,'女');
        System.out.println(o2);
    }
}
