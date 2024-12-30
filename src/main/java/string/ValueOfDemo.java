package string;

/**
 * String提供了一组静态方法:valueOf
 * 将java中其他类型转换为String
 */
public class ValueOfDemo {
    public static void main(String[] args) {
        int a = 123;
        String s1 = String.valueOf(a);//"123"
        System.out.println(s1);

        double dou = 123.123;
        String s2 = String.valueOf(dou);//"123.123"
        System.out.println(s2);

        String s3 = a + "";//java中任何类型和字符串链接结果都是字符串
        System.out.println(s3);
    }
}
