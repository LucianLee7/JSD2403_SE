package thread;

/**
 * 有效的缩小同步范围可以在保证并发安全的前提下尽可能提高并发效率
 * 同步块
 * 语法:
 * synchronized(同步监视器对象){
 *     需要多个线程同步执行的代码片段
 * }
 */
public class SyncDemo2 {
    public static void main(String[] args) {
//        Shop shop = new Shop();
        Shop shop1 = new Shop();
        Shop shop2 = new Shop();
        Thread t1 = new Thread("范传奇"){
            public void run(){
//                shop.buy();
                shop1.buy();
            }
        };
        Thread t2 = new Thread("王克晶"){
            public void run(){
//                shop.buy();
                shop2.buy();
            }
        };
        t1.start();
        t2.start();
    }
}

class Shop{
    /*
        在成员方法上使用synchronized时,同步监视器对象不可选,只能是this
     */
//    public synchronized void buy(){
    public void buy(){
        try {
            Thread t = Thread.currentThread();//获取调用buy方法的线程
            String name = t.getName();//获取线程名字
            System.out.println(name+":正在挑衣服...");
            Thread.sleep(5000);
            /*
                在使用同步块时需要自行指定同步监视器对象
                同步监视器对象的有效性:
                1:多个需要排队执行该代码块的线程看到的同步监视器对象必须是[同一个]
                2:同步监视器对象必须是引用类型

                合适的同步监视器对象:
                当多个线程存在竞争同一资源时(抢),他们应当看到的是同一个同步监视器对象
                当不存在竞争时,他们看到的不应当是同一个对象
             */
            synchronized (this) {
                System.out.println(name + ":正在试衣服...");
                Thread.sleep(5000);
            }

            System.out.println(name+":结账离开");
        } catch (InterruptedException e) {
        }
    }
}



