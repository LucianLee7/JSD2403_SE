package thread;

/**
 * 互斥锁
 * 当使用多个synchronized锁定多个不同的代码片段,但是指定的同步监视器对象是同一个时,
 * 这些代码片段间就是互斥的,多个线程不能同时访问它们
 */
public class SyncDemo6 {
    public static void main(String[] args) {
         Foo foo = new Foo();
//         Thread t1 = new Thread(()-> foo.methodA());
//         Thread t2 = new Thread(()-> foo.methodB());
        Thread t1 = new Thread(foo::methodA);
        Thread t2 = new Thread(foo::methodB);
         t1.start();
         t2.start();
    }
}

class Foo{
    public synchronized void methodA(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+":正在执行A方法...");
            Thread.sleep(5000);
            System.out.println(t.getName()+":执行A方法完毕!");
        } catch (InterruptedException e) {
        }
    }
    public synchronized void methodB(){
        try {
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+":正在执行B方法...");
            Thread.sleep(5000);
            System.out.println(t.getName()+":执行B方法完毕!");
        } catch (InterruptedException e) {
        }
    }
}
