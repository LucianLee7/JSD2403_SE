package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * 线程池是管理线程的机制,主要解决两个问题
 * 1:重复使用线程
 * 2:控制线程数量
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        //创建一个容量为2的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread t = Thread.currentThread();
                        System.out.println(t.getName()+":正在执行任务...");
                        Thread.sleep(5000);
                        System.out.println(t.getName()+":执行任务完毕");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            };
            threadPool.execute(runnable);
            System.out.println("将一个任务交给了线程池");
        }


//        threadPool.shutdown();
        threadPool.shutdownNow();
        System.out.println("线程池关闭了");

    }
}


