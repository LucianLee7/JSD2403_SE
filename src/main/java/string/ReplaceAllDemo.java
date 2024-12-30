package string;

/**
 * String支持正则表达式方法三:
 * String replaceAll(String regex,String replacement)
 * 将当前字符串中满足正则表达式的部分替换为给定内容
 */
public class ReplaceAllDemo {
    public static void main(String[] args) {
        String line = "abc123def456ghi";
        //将当前字符串line中的数字部分替换为NUMBER
        //注:如果正则表达式为"[0-9]"则每一个数字就替换一次"NUMBER"
        String newLine = line.replaceAll("[0-9]+", "NUMBER");
        System.out.println(newLine);

        //和谐用语
        String regex = "(wqnmlgb|dsb|nc|cnm|mdzz|nmsl|djb)";
        String message = "wqnmlgb!你个dsb!你怎么这么的nc!你个djb!";
        message = message.replaceAll(regex,"***");
        System.out.println(message);
    }
}










