package doc;

/**
 *  文档注释可以在三个地方使用，分别是类上，方法上(包含构造器)，常量上
 *  在类上使用时，说明当前类的整体功能
 *
 * @author 范传奇                  作者
 * @version 1.0                   版本号
 * @see String          参考，参见
 * @since JDK1.5                  始于哪个版本
 *
 */
public class DocDemo {
    /**
     * 说明常量的作用
     */
    public static final String INFO = "你好:";

    /**
     * 为用户添加问候语                     整体说明当前方法的作用
     *
     * @param name   给定的用户的名字       解释参数的意义(传入参数的格式等要求)
     * @return       带有问候语的字符串     解释返回值是什么
     */
    public String sayHello(String name){
        return "你好:"+name;
    }

}












