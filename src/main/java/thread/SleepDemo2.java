package thread;

/**
 * sleep阻塞的中断
 * 当一个线程调用sleep方法进入阻塞的过程中,若该线程的interrupt()方法被调用,那么就会立即
 * 中断它的睡眠阻塞,测试sleep方法就会对外抛出中断异常.
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin = new Thread(){
            public void run(){
                System.out.println("林:刚美完容,睡一会吧...");
                try {
                    Thread.sleep(500000000);
                } catch (InterruptedException e) {
                    //这里应当处理被唤醒的操作
                    System.out.println("林:干嘛呢!干嘛呢!干嘛呢!都破了相了!");
                }
                System.out.println("林:醒了");
            }
        };

        Thread huang = new Thread(){
            public void run() {
                System.out.println("黄:大锤80,小锤40!开始砸墙");
                for (int i=0;i<5;i++){
                    System.out.println("黄:80!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("咣当!");
                System.out.println("黄:大哥,搞定!");
                lin.interrupt();//中断lin线程的睡眠阻塞
            }
        };

        lin.start();
        huang.start();
    }
}




