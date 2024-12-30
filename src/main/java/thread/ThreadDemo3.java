package thread;

/**
 * 使用匿名内部类完成线程的两种创建方式
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //第一种创建线程的方式:继承Thread重写run方法的形式
        Thread t1 = new Thread(){
            public void run(){
                for (int i = 0; i < 1000; i++) {
                    System.out.println("你是谁啊?");
                }
            }
        };
        //第二种创建线程的方式:实现Runnable接口重写run方法的形式
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 1000; i++) {
//                    System.out.println("我是查水表的!");
//                }
//            }
//        };
//        Thread t2 = new Thread(r2);

        //Runnable接口可以使用lambda表达式创建
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                System.out.println("我是查水表的!");
            }
        });

        t1.start();
        t2.start();
    }
}



