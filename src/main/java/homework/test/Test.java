package homework.test;

public class Test {
    public static void main(String[] args) {
        A a = new B();
    }
}
class A{
    {
        System.out.println("父类代码块");
    }
    static {
        System.out.println("父类静态代码块");
    }
    public A(){
        System.out.println("父类构造方法");
    }
}
class B extends A{
    {
        System.out.println("子类代码块");
    }
    static {
        System.out.println("子类静态代码块");
    }
    public B(){
        System.out.println("子类构造方法");
    }
}