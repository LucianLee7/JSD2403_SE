package exception;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之后，java推出了一个新的特性:自动关闭特性
 * 旨在使用异常处理机制时可以简化繁琐的代码
 */
public class AutoCloseableDemo {
    public static void main(String[] args) {
        //最终代码编译后的样子可以参照FinallyDemo2的样子
        try(
            //只有实现了AutoCloseable接口的类才可以在try()中定义，否则编译不通过
            //在try()中定义的流，编译器会补充finally,调用close将它关闭
            //java中所有的流都实现了AutoCloseable接口
            FileOutputStream fos = new FileOutputStream("fos.dat");
//            String name = "";//编译不通过
        ){
            fos.write(1);
        } catch (IOException e) {
            System.out.println("出错了");
        }
    }
}






