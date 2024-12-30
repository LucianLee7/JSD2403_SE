package reflect;

import java.lang.reflect.Method;

/**
 * 使用反射机制调用有参方法
 */
public class ReflectDemo5 {
    public static void main(String[] args)throws Exception {
        Person p = new Person();
        p.say("你好");
        p.say("呵呵",5);

        Class cls = Class.forName("reflect.Person");
        Object obj = cls.newInstance();

        Method method = cls.getMethod("say",String.class);//say(String)
        method.invoke(obj,"大家好!");//obj.say("大家好!")

        Method method1 = cls.getMethod("say", String.class, int.class);
        method1.invoke(obj,"哈哈",6);


    }
}
