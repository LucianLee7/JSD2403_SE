package thread;

/**
 * 守护线程
 * 守护线程是通过调用线程的setDaemon(true)设置而转变的。
 * 正常常见线程时，默认都是用户线程。
 * 守护线程与用户线程的区别:在于进程结束时
 * 当一个java进程中所有用户线程都结束时，进程就会结束，此时会无差别杀死所有还在运行的
 * 守护线程
 */
public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread rose = new Thread(){
            public void run(){
                for (int i = 0; i < 5; i++) {
                    System.out.println("rose:let me go!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("rose:啊啊啊啊啊啊啊AAAAAAAAaaaaaa...");
                System.out.println("噗通");
            }
        };

        Thread jack = new Thread(){
            public void run(){
                while(true){
                    System.out.println("jack:you jump!i jump!");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        rose.start();
        //设置守护线程的工作必须在该线程启动前进行
        jack.setDaemon(true);
        jack.start();

        while (true);//如果主线程不结束,rose线程结束了,守护线程jack也不会结束
    }
}





