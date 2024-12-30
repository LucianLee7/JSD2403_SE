package exception;

/**
 *  异常处理机制中的try-catch
 *  语法:
 *  try{
 *      程序代码        A计划
 *  }catch(XXXException e){
 *      try中出现XXXException后的解决办法       A计划走不通时的B计划
 *  }
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");

        try {
//            String line = null;
//            String line = "a";
            String line = "abc";
            System.out.println(line.length());
            System.out.println(line.charAt(2));
            System.out.println(Integer.parseInt(line));
            //try语句块中报错代码以下的内容是不会执行的
            System.out.println("!!!!!!!!");
//        }catch (NullPointerException e){
//            System.out.println("出现了空指针,并且解决了");
//        //catch可以定义多个,针对try中不同异常有不同处理方案时可以分别捕获这些异常
//        }catch (StringIndexOutOfBoundsException e){
//            System.out.println("出现了字符串下标越界,并且解决了");

        //如果多个异常有相同的解决办法时,可以合并到一个catch中
        }catch(NullPointerException|StringIndexOutOfBoundsException e){
            System.out.println("出现了空指针或下标越界,并解决了");
        //捕获超类异常时,凡是它的子类型异常都可以被这个catch捕获并处理
        }catch(Exception e){
            System.out.println("反正就是出了个错!");
        }

        System.out.println("程序结束了");
    }
}
