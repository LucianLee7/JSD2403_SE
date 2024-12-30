package reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 通过Method访问方法常见信息
 */
public class ReflectDemo7 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls = Class.forName("reflect.Person");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("方法名:"+method.getName());
            System.out.println("参数个数:"+method.getParameterCount());
            int modifiers = method.getModifiers();//获取方法的访问修饰符
            switch (modifiers){
                case  Modifier.PUBLIC:
                    System.out.println("public");
                    break;
                case Modifier.PRIVATE:
                    System.out.println("private");
                    break;
                case Modifier.PROTECTED:
                    System.out.println("protected");
            }
            System.out.println("------------------");
        }
    }
}





