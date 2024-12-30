package thread;

import java.util.*;

/**
 * 并发安全的集合
 * HashSet,ArrayList,LinkedList都不是并发安全的,多线程场景下使用都会存在问题
 */
public class SyncDemo5 {
    public static void main(String[] args) {
//        Collection<Integer> c = new ArrayList<>();
//        Collection<Integer> c = new LinkedList<>();
//        Collection<Integer> c = new HashSet<>();

        //通过Collections将一个List集合转换为并发安全的集合
//        List<Integer> c = Collections.synchronizedList(new ArrayList<Integer>());
        //通过Collections将一个Set集合转换为并发安全的集合
        Set<Integer> c = Collections.synchronizedSet(new HashSet<>());
        Thread t1 = new Thread(){
            public void run(){
                for(int i=0;i<1000;i++){
                    c.add(i);
                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                for(int i=1000;i<2000;i++){
                    c.add(i);
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
        System.out.println(c.size());
        System.out.println(c);
    }
}
