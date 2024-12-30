package exception;

/**
 * throw关键字，用于主动向方法外抛出一个异常
 * 通常下列场景会主动对外抛出一个异常：
 * 1:程序出现了异常，并且该异常不应当在当前代码片段被处理(责任制问题)
 * 2:程序可以正常运行，但是不满足业务场景，可以当作异常抛出给调用者(本案例演示)
 */
public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();
//        p.setAge(22);

        try {
            /*
                当我们调用一个含有throws声明异常抛出的方法时，编译器要求这里必须
                处理这个异常，处理方式有两种:
                1:使用try-catch主动处理该异常
                2:在当前方法上继续使用throws声明将异常继续向外抛出给上层调用者
                但是永远不应当在main方法上使用throws
             */
            p.setAge(1000);//满足语法，但不满足业务
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }

        System.out.println("此人年龄:"+p.getAge());
    }
}
