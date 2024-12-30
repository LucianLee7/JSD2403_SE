package thread;

/**
 * 获取运行当前代码片段的线程
 * 线程提供了一个静态方法:
 * static Thread currentThread()
 * 该方法可以获取运行这个方法的线程
 *
 * java中所有的代码都是线程运行的，main方法也不例外，JVM启动后会自动创建一个线程并为其
 * 取名为main，然后让它执行main方法。因此我们也称运行main方法的线程为"主线程"
 */
public class ThreadInfoDemo {
    public static void main(String[] args) {
        //主线程进入main方法后，执行下面操作会将自身返回
        Thread main = Thread.currentThread();//current:当前的 thread:线程
        System.out.println("主线程:"+main);
        showInfo();
    }
    public static void showInfo(){
        Thread t = Thread.currentThread();//获取运行showInfo的线程
        System.out.println("运行showInfo的线程是:"+t);

        String name = t.getName();//获取线程名字
        System.out.println("名字:"+name);

        long id = t.getId();//获取该线程的唯一标识
        System.out.println("唯一标识:"+id);

        int priority = t.getPriority();//线程的优先级
        System.out.println("优先级:"+priority);

        boolean isAlive = t.isAlive();//当前线程是否还活着
        boolean isDaemon = t.isDaemon();//当前线程是否为守护线程
        boolean isInterrupted = t.isInterrupted();//当前线程是否被中断
        System.out.println("是否活着:"+isAlive);
        System.out.println("是否为守护线程:"+isDaemon);
        System.out.println("是否被中断:"+isInterrupted);
    }
}
