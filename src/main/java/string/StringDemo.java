package string;

/**
 * String常量池
 * String推荐我们使用字面量形式创建字符串，并且后续使用相同字面量时会重用对象
 * 因为所有字面量形式创建的字符串都会缓存在常量池中
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = "123abc";//对象会缓存到常量池中
        String s2 = "123abc";//重用对象
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);
        System.out.println("s1==s2:"+(s1==s2));
        String s3 = "123abc";//重用对象
        System.out.println("s3:"+s3);
        System.out.println("s1==s3:"+(s1==s3));
        //new一定产生新对象，java不推荐我们使用new创建字符串
        String s4 = new String("123abc");
        System.out.println("s4:"+s4);
        System.out.println("s1==s4:"+(s1==s4));//地址不同

        /*
            字符串是不变对象，即:创建后内容不可变
            拼接修改字符串内容实际上会产生新对象，因此s1的地址发生了改变
         */
        s1 = s1 + "!";//拼接产生的新对象不会缓存在常量池中
        System.out.println("s1:"+s1);//s1:123abc!   引用新对象
        System.out.println("s2:"+s2);//s2:123abc    还引用常量池对象
        System.out.println("s3:"+s3);//s2:123abc    还引用常量池对象
        /*
            触发了编译器的预编译特性
            编译器在编译源代码时，如果发现一个计算表达式可以在编译期间就确定结果时
            就会进行计算，并将结果替换该表达式
            例如:
            String s5 = "123"+"abc";   +两侧是字面量，结果可以确定
            编译器会计算，并将结果替换该表达式到字节码文件中:
            String s5 = "123abc";
         */
        String s5 = "123"+"abc";
        System.out.println("s5:"+s5);
        System.out.println("s2==s5:"+(s2==s5));//true  重用常量池对象

        String s = "123";   //"123"对象在常量池中
        //不触发预编译特性
        String s6 = s + "abc";//JVM拼接字符串产生新对象("abc"也在常量池)
        System.out.println("s6:"+s6);
        System.out.println("s2==s6:"+(s2==s6));//false

    }
}
