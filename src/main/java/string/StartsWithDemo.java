package string;

/**
 * boolean startsWith(String str)
 * 判断当前字符串是否是以给定字符串开始的
 * boolean endsWith(String str)
 * 判断当前字符串是否是以给定字符串结尾的
 */
public class StartsWithDemo {
    public static void main(String[] args) {
        String line = "www.tedu.cn";

        boolean starts = line.startsWith("www");//判断line是否是以"www"开始的
        System.out.println("starts:"+starts);
        starts = line.startsWith("WWW");
        System.out.println("starts:"+starts);

        boolean ends = line.endsWith(".com");
        System.out.println("ends:"+ends);
        ends = line.endsWith(".cn");
        System.out.println("ends:"+ends);
    }
}


