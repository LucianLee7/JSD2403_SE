package string;

/**
 * 课堂练习:实现截取域名
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "http://www.tedu.com.cn";
        String s2 = "doc.codeboy.com";
        String name1 = getHostName(s1);
        String name2 = getHostName(s2);
        System.out.println(name1);//tedu
        System.out.println(name2);//codeboy
    }
    public static String getHostName(String line){
        //1找到网址中两个"."的位置(indexOf)
        //2截取两个"."之间的内容(substring)
        int start = line.indexOf(".")+1;//第一个"."之后第一个字符的位置
        int end = line.indexOf(".",start);//第二个"."的位置
        String name = line.substring(start,end);
        return name;
    }
}







