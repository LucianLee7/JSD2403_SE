package string;

import java.util.Scanner;

/**
 * String toUpperCase()
 * 将当前字符串中的英文部分转换为全大写
 *
 * String toLowerCase()
 * 将当前字符串中的英文部分转换为全小写
 */
public class ToUpperCaseDemo {
    public static void main(String[] args) {
        String line = "我爱Java";
        System.out.println(line);
        String upper = line.toUpperCase();
        System.out.println(upper);
        String lower = line.toLowerCase();
        System.out.println(lower);

        String code = "A3u7bH";//验证码
        System.out.println("请输入验证码："+code);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

//        code = code.toLowerCase();
//        input = input.toLowerCase();
        /*
            equals: 相等
            对于String而言，使用equals就是用来比较两个字符串的内容是否相同
         */
//        System.out.println(code.equals(input));
        //String直接提供了忽略大小写比较字符串内容
        System.out.println(code.equalsIgnoreCase(input));
    }
}






