package reflect;

import java.lang.reflect.Field;

/**
 * 使用反射机制直接操作属性
 * 实际开发中很少这样做了，因为规范的编码都是属性私有化，提供公开的get,set方法，通过
 * 它们来操作属性。
 */
public class ReflectDemo8 {
    public static void main(String[] args) throws Exception {
        Teacher t = new Teacher();
        t.name = "张三";
        System.out.println(t);

        Class cls = Class.forName("reflect.Teacher");
        Object obj = cls.newInstance();
        /*
            java.lang.reflect.Filed 属性对象
            它的每一个实例用于表示一个类中的一个属性
         */
        Field field = cls.getDeclaredField("name");//获取名为"name"的属性
        field.set(obj,"李四");//obj.name="李四"
        System.out.println(obj);
        Object value = field.get(obj);//value = obj.name;
        System.out.println(value);
    }
}




