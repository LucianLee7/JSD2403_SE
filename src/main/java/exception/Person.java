package exception;

/**
 * 使用当前类测试异常的抛出
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if(age<0||age>100){
            //throw可以主动对外抛出一个异常
//            throw new RuntimeException("年龄超出了范围!");
            /*
                throw抛出异常时，除了RuntimeException之外，其他的异常都必须
                在方法上使用throws声明该异常的抛出给调用者，通知它来处理该异常
             */
//            throw new Exception("年龄超出了范围!");
            throw new IllegalAgeException("年龄超出了范围");
        }
        this.age = age;
    }
}
