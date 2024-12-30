package thread;

/**
 * StringBuilder不是并发安全的,多线程场景下修改同一个字符串会出现并发安全问题
 * StringBuffered是并发安全的,它内部的增删改插等操作都使用了synchronized修饰
 */
public class SyncDemo4 {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
        StringBuffer sb = new StringBuffer();
        Thread t1 = new Thread(){
            public void run(){
                for(int i=0;i<1000;i++){
                    sb.append("abc");
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                for(int i=0;i<1000;i++){
                    sb.append("def");
                }
            }
        };
        t1.start();
        t2.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sb.length());
        System.out.println(sb);
    }
}
