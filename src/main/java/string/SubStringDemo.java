package string;

/**
 * String substring(int start,int end)
 * 截取当前字符串中指定范围内的字符串
 * 注意:在java API中，通常使用两个数字表示下标范围时都是"含头不含尾"的
 */
public class SubStringDemo {
    public static void main(String[] args) {
        //             01234567890
        String line = "www.tedu.cn";

        String sub = line.substring(4,8);
        System.out.println(sub);

        sub = line.substring(4);//从下标4处开始，截取到字符串末尾
        System.out.println(sub);


    }
}
