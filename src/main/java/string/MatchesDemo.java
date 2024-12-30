package string;

/**
 * String支持正则表达式的方法一:
 * boolean matches(String regex)
 * 使用给定的正则表达式验证当前字符串是否满足格式要求，满足则方法返回true，否则返回false
 */
public class MatchesDemo {
    public static void main(String[] args) {
        /*
            邮箱格式:
            用户名@域名.后缀

            [a-zA-Z0-9_]+@[a-zA-Z0-9]+(\.[a-zA-Z]+)+
         */
        String email = "fan_chuanqi123@yahoo.com.cn";
        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        boolean flag = email.matches(regex);
        System.out.println(flag?"验证通过":"验证失败");

    }
}



