package exception;

/**
 * 异常中常用的方法
 */
public class ExceptionApiDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            String line = "abc";
            System.out.println(Integer.parseInt(line));
        } catch (NumberFormatException e) {
            e.printStackTrace();//向控制台输出错误的跟踪信息

            //获取错误消息，通常用于记录日志或为用户进行提示使用
            String message = e.getMessage();
            System.out.println(message);
        }
        System.out.println("程序结束了");
    }
}



