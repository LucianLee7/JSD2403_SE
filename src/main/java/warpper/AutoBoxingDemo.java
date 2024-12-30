package warpper;

/**
 * JDK1.5推出时,推出了一个新特性:自动拆装箱
 */
public class AutoBoxingDemo {
    public static void main(String[] args) {
        int a = 123;
        /*
            自动拆装箱特性是编译器认可的,而不是虚拟机

            当编译器编译源代码时,发现将基本类型直接赋值给引用类型时,会补充代码,将基本
            类型转换为对应的包装类.
            下面的代码:
            Integer i = a;
            在编译后的字节码文件中被编译器补充了代码:
            Integer i = Integer.valueOf(a);
            上述操作就是编译器的自动装箱特性
         */
        Integer i = a;
        /*
            当编译器发现将包装类赋值给了基本类型时,会触发自动拆箱特性
            编译器会将下面的代码改为:
            int b = i.intValue();
         */
        int b = i;
        /*
            触发自动装箱特性:
            method(Integer.valueOf(b));
         */
        method(b);
    }

    public static void method(Object i){
        System.out.println(i);
    }
}



