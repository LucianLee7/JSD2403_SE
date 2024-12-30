package object;

/**
 * 测试Object中经常被子类重写的方法
 */
public class Demo {
    public static void main(String[] args) {
        Point point = new Point(1,2);
        /*
            Object实现了toString方法，默认返回的格式为:类名@地址
         */
//        String str = point.toString();
//        System.out.println(str);
        //toString常用的场景之一:输出对象，此时实际上输出的就是对象toString返回的字符串
        System.out.println(point);
        //场景二:任何类型与字符串连接结果都是字符串，此时也会调用toString转换为字符串
        String line = "这是一个Point类:"+point;
        System.out.println(line);

        Point p2 = new Point(1,2);
        System.out.println(point==p2);//比地址，两个对象，因此地址不同:false
        /*
            Object定义的equals方法意义:比较两个对象的内容是否相同
            而Object默认实现时直接使用"=="比较，因此如果子类不重写该方法则该方法没有意义
         */
        System.out.println(point.equals(p2));//内容相同:true

    }
}






