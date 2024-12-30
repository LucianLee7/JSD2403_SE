package thread;

/**
 * 线程的优先级
 * 线程一共有10个优先级，分别用整数1-10表示
 * 其中1为最低优先级，5为默认值，10为最高优先级
 *
 * 当线程调用start启动后，就会纳入到线程的调度器中被统一管理，此时线程只能被动分配
 * 时间片并发执行，无法主动索取时间片。
 * 调整线程的优先级可以最大程度改变线程获取时间片的概率，优先级越高的线程获取时间片的次数越多
 */
public class PriorityDemo {
    public static void main(String[] args) {
        Thread min = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    System.out.println("min");
                }
            }
        };
        Thread max = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    System.out.println("max");
                }
            }
        };
        Thread norm = new Thread(){
            public void run(){
                for (int i = 0; i < 10000; i++) {
                    System.out.println("nor");
                }
            }
        };
//        min.setPriority(1);//设置最小优先级
        min.setPriority(Thread.MIN_PRIORITY);
        max.setPriority(Thread.MAX_PRIORITY);
        min.start();
        norm.start();
        max.start();

    }
}





