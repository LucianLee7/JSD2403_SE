package thread;

import java.util.Scanner;

/**
 * sleep阻塞
 * 线程提供了一个静态方法:
 * static void sleep(long ms)
 * 让当前线程阻塞指定毫秒，超时后线程会再次开始并发执行后续代码
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");
        try {
            /*
                简易的倒计时程序
                程序开始后，要求在控制台上输入一个数字，从该数字开始每秒递减
                到0时输出时间到
             */
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入一个数字");
            for(int num = scanner.nextInt();num>0;num--) {
                System.out.println(num);
                Thread.sleep(1000);
            }
            System.out.println("时间到!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("程序结束了");
    }
}
