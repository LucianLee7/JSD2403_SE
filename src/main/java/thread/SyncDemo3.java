package thread;

/**
 * 静态方法上的同步
 * 当使用synchronized修饰一个静态方法时,该方法一定具有同步效果.
 *
 * 静态方法上使用synchronized时同步监视器对象依然不可选,只能是当前类的类对象
 * Class的实例(类对象知识点后面学习反射时会详细介绍)
 * 目前需要了解:java中任何一个类都有且只有一个类对象与之对应
 *
 */
public class SyncDemo3 {
    public static void main(String[] args) {
//        Boo b1 = new Boo();
//        Boo b2 = new Boo();
//        Thread t1 = new Thread(()->b1.doSome());
//        Thread t2 = new Thread(()->b2.doSome());

        Thread t1 = new Thread(()->Boo.doSome());
        Thread t2 = new Thread(()->Boo.doSome());
        t1.start();
        t2.start();
    }
}

class Boo{
//    public synchronized static void doSome(){
    public static void doSome(){
        //显示的获取类对象可以用:类名.class获取到
        synchronized (Boo.class) {//静态方法中指定同步监视器对象通常就用当前类的类对象
            try {
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + ":正在执行doSome方法...");
                Thread.sleep(5000);
                System.out.println(t.getName() + ":执行doSome方法完毕!");
            } catch (InterruptedException e) {
            }
        }
    }
}




