package thread;

/**
 * 演示多线程并发安全问题
 *
 * 当多个线程并发访问同一临界资源,由于线程切换时机不确定,导致操作顺序出现混乱,从而产生
 * 不良影响的现象称为多线程并发安全问题
 *
 * 临界资源:访问该资源的完整过程同一时刻只能由单一一个线程操作
 */
public class SyncDemo1 {
    public static boolean success1 = false;//表示第一个人是否取款成功
    public static boolean success2 = false;//表示第二个人是否取款成功
    public static void main(String[] args) {
        Bank bank = new Bank();
        int sum = 0;
        while(true) {
            sum++;
            Thread t1 = new Thread() {
                public void run() {
                    success1 = bank.getMoney(20000);
                }
            };
            Thread t2 = new Thread() {
                public void run() {
                    success2 = bank.getMoney(20000);
                }
            };
            t1.start();
            t2.start();

            try {
                Thread.sleep(100);//让主线程阻塞100毫秒,目的是等上面两个线程取完钱
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(success1&&success2){
                System.out.println("同时取款成功!出现了并发安全问题!");
                System.out.println("总共尝试了"+sum+"次");
                break;
            }else{
                bank.saveMoney(20000);//重新存上
                success1 = false;
                success2 = false;
            }
        }
    }
}
