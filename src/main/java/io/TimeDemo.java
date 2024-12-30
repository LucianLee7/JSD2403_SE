package io;

public class TimeDemo {
    public static void main(String[] args) {
        //1970元旦到该时间之间所经过的毫秒
        long time = System.currentTimeMillis();
        System.out.println(time);
        time = time/1000/60/60/24/365;
        System.out.println(time);

        long max = Long.MAX_VALUE;
        max = max/1000/60/60/24/365;
        System.out.println("公元:"+(1970+max));
    }
}
