package thread;

/**
 * 第一种创建线程的方式:继承Thread并重写run方法
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        Thread t2 = new MyThread2();
        /*
            启动线程要注意，是调用start方法，而不是直接调用线程的run方法。
            run方法是线程用于定义该线性流程中的每一句代码。
            而要想让该线程与其他线程并发运行，要调用start方法启动它
            start方法会将该线程纳入到线程调度器中被其统一管理，之后调度器分配时间片
            给该线程第一次执行时会自动调用它的run方法
         */
        t1.start();
        t2.start();

    }
}
/*
    该创建方式的优点:结构简单，利于匿名内部类方式创建
    缺点:
    1:存在继承冲突问题
      因为java是单继承的，当我们希望当前类是一个线程，同时又需要继承另一个类去复用方法
      此时无法同时继承他们

    2:线程和线程任务存在耦合
      会导致线程的重用性变低，不利于后期线程的管理。

 */
class MyThread1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("你是谁啊？");
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println("开门！查水表的！");
        }
    }
}




