package exception;

/**
 * finally块
 * finally块是异常处理机制中的最后一块.
 * finally的特点:
 * 只要程序执行到try语句块中,无论try中的代码是否出现异常,finally最终都必定执行
 * 通常我们会将释放资源这类操作放在finally中确保执行,比如IO操作最后的close方法调用
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            //ctrl+alt+t 快捷键,用于添加try-catch
//            String line = null;
            String line = "abc";
            System.out.println(line.length());
            System.out.println(line.charAt(1));
            return;
        } catch (NullPointerException e) {
            System.out.println("报错了");
        } finally {
            //finally无论try中什么情况,最后都必定执行
            System.out.println("finally中的代码执行了");
        }
        //没有finally,如果出现了catch中没有的异常,则无法执行后续代码
        //如果try中执行了return,也无法执行后续代码
        System.out.println("finally中的代码执行了");
        System.out.println("程序结束了");
    }
}



